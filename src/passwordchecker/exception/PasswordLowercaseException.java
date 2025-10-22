package passwordchecker.exception;

/**
 * Exception thrown when password does not contain any lowercase
 */
public class PasswordLowercaseException extends PasswordValidationException{
    /**
     * Custructor for specific message
     *
     */
    public PasswordLowercaseException() {
        super("Password must contain at least one lower case");
    }
}
