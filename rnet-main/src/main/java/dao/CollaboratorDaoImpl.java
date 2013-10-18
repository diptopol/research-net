package dao;

import domain.Collaborator;
import domain.Research;
import domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/6/13
 * Time: 4:34 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class CollaboratorDaoImpl implements CollaboratorDao {
    private static final Logger logger = LoggerFactory.getLogger(CollaboratorDaoImpl.class);

    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    @Override
    public void insert(int research_id, Collaborator collaborator, User user) {
        Research research = entityManager.find(Research.class, research_id);
        collaborator.setResearch(research);
        List<Collaborator> collaboratorListForResearch = research.getCollaboratorList();
        if(collaboratorListForResearch == null) {
            collaboratorListForResearch = new ArrayList<Collaborator>();
        }
        collaboratorListForResearch.add(collaborator);
        research.setCollaboratorList(collaboratorListForResearch);

        user = entityManager.find(User.class, user.getUserId());
        collaborator.setUser(user);
        List<Collaborator> collaboratorListForUser = user.getCollaboratorList();
        if(collaboratorListForUser == null) {
            collaboratorListForUser = new ArrayList<Collaborator>();
        }
        collaboratorListForUser.add(collaborator);
        user.setCollaboratorList(collaboratorListForUser);
    }

    @Override
    public List<Collaborator> findCollaboratorsBy(int research_id) {
        List<Collaborator> collaboratorList = entityManager.createQuery("SELECT collaborator FROM Collaborator collaborator WHERE " +
                "collaborator.research.researchId =:id")
                .setParameter("id", research_id).getResultList();
        return collaboratorList;
    }

    @Override
    public Collaborator findCollaboratorBy(int researchId, int userId) {
        return (Collaborator)entityManager.createQuery("SELECT collaborator FROM Collaborator collaborator WHERE " +
                "collaborator.research.researchId =:r_id AND collaborator.user.userId =:u_id")
                .setParameter("r_id", researchId)
                .setParameter("u_id", userId).getSingleResult();
    }
}
