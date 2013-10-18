package services;

import dao.CollaboratorDao;
import domain.Collaborator;

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
    @Override
    public List<Collaborator> findCollaboratorsBy(int research_id) {
        return collaboratorDao.findCollaboratorsBy(research_id);
    }

    public Collaborator findCollaboratorBy(int researchId, int userId) {
         return collaboratorDao.findCollaboratorBy(researchId, userId);
    }
}
