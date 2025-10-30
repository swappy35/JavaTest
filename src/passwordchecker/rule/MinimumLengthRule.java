package passwordchecker.rule;

import passwordchecker.exception.PasswordLengthException;
import passwordchecker.exception.PasswordValidationException;

/**
 * Validation to check minimum password length
 */
public class MinimumLengthRule implements ValidationRule {
    private final int minLength=8;

    /**
     * Constructor a Minimum Length rule
     *
     * @param minLength the minimum required length
     */
   // public MinimumLengthRule(int minLength) {
     //   this.minLength = minLength;
    //}

    /**
     * Validates that password meets minimum length requirement
     *
     * @param password to validate
     * @throws PasswordValidationException if password is too short
     */
    @Override
    public  void validate(String password) throws PasswordValidationException {
        if (password != null && password.length() >= minLength && hasUppercase(password)==true
                && hasLowercase(password)==true && containsAlteastOneNumber(password)==true){
            throw new PasswordLengthException(minLength);
        }
    }
    public  static boolean hasLowercase(String password) {
        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                return true;
            }
        }
        return false;
    }
    public  static boolean hasUppercase(String password)
    {
        for (char ch: password.toCharArray())
        {
            if(Character.isUpperCase(ch))
            {
                return true;
            }
        }
        return false;
    }
    public  static boolean containsAlteastOneNumber(String password) {
        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }
}
