package passwordchecker.rule;

import passwordchecker.exception.PasswordLowercaseException;
import passwordchecker.exception.PasswordUppercaseException;
import passwordchecker.exception.PasswordValidationException;

/**
 * Validation rule to check at least one lower letter
 */
public class LowercaseRule implements ValidationRule {

    /**
     * Validation rule to check at least one lowercase letter
     *
     * @param password to validate
     * @throws PasswordValidationException if no lowercase in the password
     */
    @Override
    public void validate(String password) throws PasswordValidationException {
        if (password == null || !password.chars().anyMatch(Character::isLowerCase)) {
            throw new PasswordLowercaseException();
        }
    }
}
