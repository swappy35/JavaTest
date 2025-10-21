package passwordchecker.main;

public class PasswordChecker {

    public void checkPassword(String password) throws PasswordCheckerException {
        checkNotNull(password);
        checkLength(password);
        checkUpperCase(password);
        checkLowerCase(password);
        checkNumber(password);
    }

    public boolean isPasswordOk(String password) {
        if (password == null || password.length() <= 8) {
            return false;
        }

        int checkFlag = 0;

        if (containsUpperCase(password)) {
            checkFlag++;
        }

        if (containsLowerCase(password)) {
            checkFlag++;
        }

        if (containsNumber(password)) {
            checkFlag++;
        }

        return checkFlag >= 3;
    }

    private void checkNotNull(String password) throws PasswordCheckerException {
        if (password == null) {
            throw new PasswordCheckerException("Password can not be null");
        }
    }

    private void checkLength(String password) throws PasswordCheckerException {
        if (password.length() <= 8) {
            throw new PasswordCheckerException("Password should be greater than 8 characters");
        }
    }

    private void checkUpperCase(String password) throws PasswordCheckerException {
        if (!containsUpperCase(password)) {
            throw new PasswordCheckerException("Password should have at least one uppercase");
        }
    }

    private void checkLowerCase(String password) throws PasswordCheckerException {
        if (!containsLowerCase(password)) {
            throw new PasswordCheckerException("Password should have at least one lowercase");
        }
    }

    private void checkNumber(String password) throws PasswordCheckerException {
        if (!containsNumber(password)) {
            throw new PasswordCheckerException("Password should have at least one number");
        }
    }

    private boolean containsUpperCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean containsLowerCase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean containsNumber(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
