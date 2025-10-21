package passwordchecker.test;

import passwordchecker.main.PasswordCheckerException;
import passwordchecker.main.PasswordChecker;

public class PasswordCheckerTest {

    private PasswordChecker checker;

    public PasswordCheckerTest() {
        checker = new PasswordChecker();
    }

    public void runTest() {
        testNull();
        testShortPass();
        testNoUpperCase();
        testNoLowerCase();
        testNoNumber();
        testExactlyEight();
        testValidPass();
        testOkWithThreeCondition();
        testOkWithTwoCondition();
        testNotOkWithInvalidLength();
    }

    private void  testNull() {
        try {
            checker.checkPassword(null);
        } catch (PasswordCheckerException e) {
            if (e.getMessage().contains("null")) {
                System.out.println("Pass: testNullPassword");
            } else {
                System.out.println("Fail: testNullPassword");
            }
        }
    }

    private void  testShortPass() {
        try {
            checker.checkPassword("As1dth");
        } catch (PasswordCheckerException e) {
            if (e.getMessage().contains("greater than 8")) {
                System.out.println("Pass: testShortPass");
            } else {
                System.out.println("Fail: testNullPassword");
            }
        }
    }

    private void  testNoUpperCase() {
        try {
            checker.checkPassword("123swapnil");
        } catch (PasswordCheckerException e) {
            if (e.getMessage().contains("uppercase")) {
                System.out.println("Pass: testNoUpperCase");
            } else {
                System.out.println("Fail: testNoUpperCase");
            }
        }
    }

    private void  testNoLowerCase() {
        try {
            checker.checkPassword("123SWAPNIL");
            System.out.println("Fail: testNoLowerCase");
        } catch (PasswordCheckerException e) {
            if (e.getMessage().contains("lowercase")) {
                System.out.println("Pass: testNoLowerCase");
            } else {
                System.out.println("Fail: testNoLowerCase");
            }
        }
    }

    private void  testNoNumber() {
        try {
            checker.checkPassword("palSWAPNIL");
        } catch (PasswordCheckerException e) {
            if (e.getMessage().contains("number")) {
                System.out.println("Pass: testNoNumber");
            } else {
                System.out.println("Fail: testNoNumber");
            }
        }
    }

    private void  testExactlyEight() {
        try {
            checker.checkPassword("Swapnil1");
        } catch (PasswordCheckerException e) {
            if (e.getMessage().contains("greater than 8")) {
                System.out.println("Pass: testExactlyEight");
            } else {
                System.out.println("Fail: testExactlyEight");
            }
        }
    }

    private void  testValidPass() {
        try {
            checker.checkPassword("Swapnil123");
            System.out.println("Pass: testValidPass");
        } catch (PasswordCheckerException e) {
            System.out.println("Fail: testValidPass");
        }
    }

    private void  testOkWithThreeCondition() {
        boolean result = checker.isPasswordOk("PalSwapnil123");
        if (result) {
            System.out.println("Pass: testOkWithThreeCondition");
        } else {
            System.out.println("Fail: testOkWithThreeCondition");
        }
    }

    private void  testOkWithTwoCondition() {
        boolean result = checker.isPasswordOk("swapnilpal");
        if (result) {
            System.out.println("Pass: testOkWithTwoCondition");
        } else {
            System.out.println("Expected Fail but Pass: testOkWithTwoCondition");
        }
    }

    private void  testNotOkWithInvalidLength() {
        boolean result = checker.isPasswordOk("Pal12");
        if (result) {
            System.out.println("Pass: testNotOkWithInvalidLength");
        } else {
            System.out.println("Expected Fail but Pass: testNotOkWithInvalidLength");
        }
    }

    public static void main(String[] args) {
        PasswordCheckerTest test = new PasswordCheckerTest();
        test.runTest();
    }
}
