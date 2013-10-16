package dao;

import domain.Research;
import exceptions.NoResearchFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/6/13
 * Time: 4:19 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class ResearchDaoImpl implements ResearchDao {
    private static final Logger logger = LoggerFactory.getLogger(ResearchDaoImpl.class);
    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    @Override
    public int insert(Research research) throws NoResearchFoundException{
        logger.info("ResearchDAoImpl :"+research.getResearchTitle());
        entityManager.persist(research);
        logger.info("ResearchDAoImpl : Afer persist "+research.getResearchTitle());
        List<Research> researchList = (List<Research>)entityManager.createQuery("SELECT research FROM Research research WHERE " +
                "research.researchTitle =:title AND " +
                "research.researchStatus =:status AND " +
                "research.researchData =:data AND " +
                "research.startingTime =:time")
                .setParameter("title", research.getResearchTitle())
                .setParameter("status", research.getResearchStatus())
                .setParameter("data", research.getResearchData())
                .setParameter("time", research.getStartingTime())
                .getResultList();

        if(researchList.isEmpty()) {
            logger.info("ResearchDaoImpl :empty");
            throw new NoResearchFoundException();
        }
        else {
            return researchList.get(0).getResearchId();
        }

    }

    public Research findResearchBy(int researchId) {
        return entityManager.find(Research.class, researchId);
    }


}
