package services;

import dao.CollaboratorDao;
import dao.ResearchDao;
import domain.Collaborator;
import domain.Research;
import domain.User;
import exceptions.NoResearchFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/6/13
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class ResearchServiceImpl implements ResearchService{
    private Logger logger = LoggerFactory.getLogger(ResearchServiceImpl.class);
    @EJB
    private ResearchDao researchDao;
    @EJB
    private CollaboratorDao collaboratorDao;

    @Override
    @TransactionAttribute
    public int createResearchProject(Research research, Collaborator collaborator, User user) throws NoResearchFoundException{
        int research_id = researchDao.insert(research);
        logger.info("ResearchServiceImpl :"+research.getResearchId());
        collaboratorDao.insert(research_id, collaborator, user);
        return research_id;
    }

    public Research findResearchBy(int research_id) {
         return researchDao.findResearchBy(research_id);
    }

    public List<Research> findResearchList(int page_number) {
        return researchDao.findResearchList(page_number);
    }

    public void updateResearch(Research research) {
        researchDao.updateResearch(research);
    }
}
