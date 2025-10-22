package passwordchecker.rule;

import passwordchecker.exception.PasswordUppercaseException;
import passwordchecker.exception.PasswordValidationException;

/**
 * Validation rule to check at least one uppercase letter
 */
public class UppercaseRule implements ValidationRule {

    /**
     * Validation rule to check at least one uppercase letter
     *
     * @param password to validate
     * @throws PasswordValidationException if no uppercase in the password
     */
    @Override
    public void validate(String password) throws PasswordValidationException {
        if (password == null || !password.chars().anyMatch(Character::isUpperCase)) {
            throw new PasswordUppercaseException();
        }
    }
}
