package passwordchecker.exception;

/**
 * Exception thrown when password does not contain any uppercase
 */
public class PasswordUppercaseException extends PasswordValidationException{
    /**
     * Custructor for specific message
     *
     */
    public PasswordUppercaseException() {
        super("Password must contain at least one upper case");
    }
}
