package exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/4/13
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseConnectionException extends Exception {
    public DatabaseConnectionException() {
    }

    public DatabaseConnectionException(String message) {
        super(message);
    }
}
