package passwordchecker.exception;

/**
 * Exception for password null
 */
public class PasswordNullException extends PasswordValidationException{

    /**
     * Constructor for password null exception with default message
     */
    public PasswordNullException() {
        super("Password can not be null");
    }
}
