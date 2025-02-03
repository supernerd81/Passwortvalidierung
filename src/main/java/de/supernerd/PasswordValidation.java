package de.supernerd;

public class PasswordValidation {

    private static byte minimumLengthPassword = 8;

    public static boolean hasAtLeastEightCharacters(String password) {

        if(password.length() >= minimumLengthPassword) {
            return true;
        }

        return false;
    }
}
