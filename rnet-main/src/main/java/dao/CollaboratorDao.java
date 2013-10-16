package dao;

import domain.Collaborator;
import domain.Research;
import domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/6/13
 * Time: 4:32 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CollaboratorDao {
    public void insert(int research_id, Collaborator collaborator, User user);
    public List<Collaborator> findCollaboratorsBy(int research_id);
}
