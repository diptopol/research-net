package services;

import domain.Collaborator;
import domain.Research;
import domain.User;
import exceptions.NoResearchFoundException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/6/13
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
public interface ResearchService {
    public int createResearchProject(Research research, Collaborator collaborator, User user) throws NoResearchFoundException;
    public Research findResearchBy(int research_id);
    public List<Research> findResearchList(int page_number);
}
