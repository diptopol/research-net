package services;

import dao.CollaboratorDao;
import dao.ResearchDao;
import dao.UserDao;
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
    @EJB
    private UserDao userDao;

    @Override
    @TransactionAttribute
    public int createResearchProject(Research research, Collaborator collaborator, int userId) throws NoResearchFoundException{
        User user = userDao.findUserBy(userId);
        int research_id = researchDao.insert(research);
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

    public List<Research> findCompleteResearchListBy(int userId) {
        return researchDao.findCompleteResearchListBy(userId);
    }

    public List<Research> findIncompleteResearchListBy(int userId) {
        return researchDao.findIncompleteResearchListBy(userId);
    }
}
