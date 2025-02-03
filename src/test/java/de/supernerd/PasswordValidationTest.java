package de.supernerd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidationTest {
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
}
