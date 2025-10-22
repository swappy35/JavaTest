package passwordchecker.exception;

/**
 * Exception thrown when password does not contain any number
 */
public class PasswordNumberException extends PasswordValidationException{
    /**
     * Custructor for specific message
     *
     */
    public PasswordNumberException() {
        super("Password must contain at least one number");
    }
}
