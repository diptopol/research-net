package dao;

import domain.Research;
import exceptions.NoResearchFoundException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/6/13
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ResearchDao {
    public int insert(Research research) throws NoResearchFoundException;
    public Research findResearchBy(int researchId);
    public List<Research> findResearchList(int page_number);
}
