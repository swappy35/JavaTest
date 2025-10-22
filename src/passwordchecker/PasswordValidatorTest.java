package passwordchecker;

import passwordchecker.model.ValidationResult;
import passwordchecker.service.PasswordValidator;
import passwordchecker.service.PasswordValidatorImpl;

public class PasswordValidatorTest {

    private final PasswordValidator validator = new PasswordValidatorImpl();

    public static void main(String[] args){
        PasswordValidatorTest test = new PasswordValidatorTest();
        test.testNullPassword();
        test.testShortPassword();
        test.testNoUppercase();
        test.testNoLowercase();
        test.testNoNumber();
        test.testValidPassword();
        test.testEasyPassword();

    }

    private void testEasyPassword() {
        System.out.println("Easy password test");
        assert validator.isPasswordOk("swapnil123") : "Password with 3 out 5 rules is Ok";
        System.out.println("Passed");
    }

    private void testValidPassword() {
        System.out.println("Valid password test");
        ValidationResult result = validator.validate("SwapnilPal123");
        assert result.isValid() : "Password valid --> Pass";
        assert validator.isPasswordOk("SwapnilPal123") : "Valid password is Ok";
        System.out.println("Passed");
    }

    private void testNoNumber() {
        System.out.println("No Number password test");
        ValidationResult result = validator.validate("SWAPNILpal");
        assert !result.isValid() : "Password No Number --> Fail";
        System.out.println("Passed");
    }

    private void testNoLowercase() {
        System.out.println("No Lowercase password test");
        ValidationResult result = validator.validate("SWAPNIL123");
        assert !result.isValid() : "Password No Lowercase --> Fail";
        System.out.println("Passed");
    }

    private void testNoUppercase() {
        System.out.println("No Uppercase password test");
        ValidationResult result = validator.validate("swapnil123");
        assert !result.isValid() : "Password No Uppercase --> Fail";
        System.out.println("Passed");
    }

    private void testShortPassword() {
        System.out.println("Short password test");
        ValidationResult result = validator.validate("Swap12");
        assert !result.isValid() : "Password short --> Fail";
        System.out.println("Passed");
    }

    private void testNullPassword() {
        System.out.println("Null password test");
        ValidationResult result = validator.validate(null);
        assert !result.isValid() : "Password null --> Fail";
        assert !validator.isPasswordOk(null) : "Null password is not Ok";
        System.out.println("Passed");
    }


}
