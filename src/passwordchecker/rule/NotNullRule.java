package passwordchecker.rule;

import passwordchecker.exception.PasswordNullException;
import passwordchecker.exception.PasswordValidationException;

/**
 * Validation rule to check if the password is null or not
 */
public class NotNullRule implements ValidationRule {

    /**
     * Validation rule to check if the password is null or not
     *
     * @param password input password to validate
     * @throws PasswordValidationException if password is null
     */
    @Override
    public void validate(String password) throws PasswordValidationException {
        if (password == null) {
            throw new PasswordNullException();
        }
    }
}
