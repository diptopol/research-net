package exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/7/13
 * Time: 1:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class NoResearchFoundException extends Exception {
    public NoResearchFoundException() {
    }
    public NoResearchFoundException(String message) {
        super(message);
    }
}
