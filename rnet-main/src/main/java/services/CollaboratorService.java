package services;

import domain.Collaborator;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/8/13
 * Time: 12:12 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CollaboratorService {
    public List<Collaborator> findCollaboratorsBy(int research_id);
    public Collaborator findCollaboratorBy(int researchId, int userId);
    public void CollaboratorInsert(int research_id, Collaborator collaborator, int userId);
}
