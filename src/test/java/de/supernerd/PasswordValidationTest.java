package de.supernerd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidationTest {
    // Minimum eight Characters
    @Test
    void hasAtLeastEightCharacters() {
        String password = "Test1234556";

        Assertions.assertTrue(PasswordValidation.hasAtLeastEightCharacters(password));
    }

    @Test
    void passwordHasLessThanEightCharacters() {
        String password = "Test12";

        Assertions.assertFalse(PasswordValidation.hasAtLeastEightCharacters(password));
    }

    @Test
    void passwordHasExcactlyEightCharaters() {
        String password = "Test1234";

        Assertions.assertTrue(PasswordValidation.hasAtLeastEightCharacters(password));
    }



    // Contains minimum one Number
    @Test
    void passwordHasContainsNumbers_MinimumOneNumber() {
        String password = "Test554655";
        boolean returns = PasswordValidation.containsNumbers(password);

        Assertions.assertTrue(returns);
    }

    @Test
    void passwordHasContainsNumbers_containsNoNumber() {
        String password = "testkjdhafsadf";
        boolean returns = PasswordValidation.containsNumbers(password);

        Assertions.assertFalse(returns);
    }

    @Test
    void passwordHasContainsNumber_withNumbersInTheMiddle() {
        String password = "slakf4555dkjjk";
        boolean returns = PasswordValidation.containsNumbers(password);

        Assertions.assertTrue(returns);
    }

    @Test
    void passwordHasContainsNumber_withOneNumber() {
        String password = "Test4test";
        boolean returns = PasswordValidation.containsNumbers(password);

        Assertions.assertTrue(returns);

    }


    // Uppercase and lowercase
    @Test
    void containsUppercaseAndLowercaseLetter_withUpperAndLowercaseLetters() {
        String password = "Akdkkktest55";
        boolean returns = PasswordValidation.containsUppercaseAndLowercaseLetters(password);

        Assertions.assertTrue(returns);
    }

    @Test
    void containsUppercaseAndLowercaseLetter_withCapitalLettersInTheSecondWord() {
        String password = "akdkkk Atest55";
        boolean returns = PasswordValidation.containsUppercaseAndLowercaseLetters(password);

        Assertions.assertTrue(returns);
    }

    @Test
    void containsUppercaseAndLowercaseLetter_onlyLowercaseLetters() {
        String password = "akdkkk atest55";
        boolean returns = PasswordValidation.containsUppercaseAndLowercaseLetters(password);

        Assertions.assertFalse(returns);
    }

    @Test
    void containsUppercaseAndLowercaseLetter_onlyUppercaseLetters() {
        String password = "TEST";
        boolean returns = PasswordValidation.containsUppercaseAndLowercaseLetters(password);

        Assertions.assertFalse(returns);
    }


    // FrequentlyUsed
    @Test
    void frequentlyUsed_wordsKnown() {
        String password = "7=9haHausbWBD§§,eDxc";
        boolean returns = PasswordValidation.frequentlyUsed(password);

        Assertions.assertTrue(returns);
    }

    @Test
    void frequentlyUsed_wordsKnown_lowercase() {
        String password = "7=9ha haus bWBD§§,eDxc";
        boolean returns = PasswordValidation.frequentlyUsed(password);

        Assertions.assertTrue(returns);
    }

    @Test
    void frequentlyUsed_wordsKnown_lowercase_containAnotherWord() {
        String password = "7=9ha Garten bWBD§§,eDxc";
        boolean returns = PasswordValidation.frequentlyUsed(password);

        Assertions.assertTrue(returns);
    }

    @Test
    void frequentlyUsed_wordsNotKnown() {
        String password = "7=9habWBD§§,eDxc";
        boolean returns = PasswordValidation.frequentlyUsed(password);

        Assertions.assertFalse(returns);
    }

    @Test
    void frequentlyUsed_numberSequence_atLeastThree() {
        String password = "a2345584";
        boolean returns = PasswordValidation.frequentlyUsed(password);

        Assertions.assertTrue(returns);
    }

    @Test
    void frequentlyUsed_numberSequence_lessThree() {
        String password = "a235584";
        boolean returns = PasswordValidation.frequentlyUsed(password);

        Assertions.assertFalse(returns);
    }

}
