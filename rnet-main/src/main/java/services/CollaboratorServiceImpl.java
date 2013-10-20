package services;

import dao.CollaboratorDao;
import dao.UserDao;
import domain.Collaborator;
import domain.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/8/13
 * Time: 12:14 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class CollaboratorServiceImpl implements CollaboratorService {
    @EJB
    private CollaboratorDao collaboratorDao;
    @EJB
    private UserDao userDao;
    @Override
    public List<Collaborator> findCollaboratorsBy(int research_id) {
        return collaboratorDao.findCollaboratorsBy(research_id);
    }

    public Collaborator findCollaboratorBy(int researchId, int userId) {
         return collaboratorDao.findCollaboratorBy(researchId, userId);
    }

    public void CollaboratorInsert(int research_id, Collaborator collaborator, int userId) {
        User user = userDao.findUserBy(userId);
        collaboratorDao.insert(research_id, collaborator, user);
    }
}
