package de.supernerd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidation {

    private static byte minimumLengthPassword = 8;

    public static void main(String[] args) {

        int zahl1 = 5;
        int zahl2 = 55;
        String b = "15";

        System.out.println(zahl2+b);

    }

    public static boolean hasAtLeastEightCharacters(String password) {

        if(password.length() >= minimumLengthPassword) {
            return true;
        }

        return false;
    }

    public static boolean containsNumbers(String password) {

        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(password);

        return matcher.find();
    }

    public static boolean containsUppercaseAndLowercaseLetters(String password) {

        Pattern pattern = Pattern.compile("[A-Z]+[a-z]+");
        Matcher matcher = pattern.matcher(password);

        return matcher.find();
    }
}
