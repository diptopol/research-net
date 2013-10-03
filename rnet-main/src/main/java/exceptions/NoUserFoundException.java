package exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/2/13
 * Time: 9:40 AM
 * To change this template use File | Settings | File Templates.
 */
public class NoUserFoundException extends Exception {
    public NoUserFoundException() {
    }

    public NoUserFoundException(String message) {
        super(message);
    }
}
