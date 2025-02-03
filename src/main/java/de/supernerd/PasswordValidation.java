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

    public static boolean frequentlyUsed(String password) {

        String[] easyPasswords = { "Password", "Haus", "Garten", "Name", "Aa345678"};
        Pattern pattern;
        Matcher matcher;

        for(String value : easyPasswords) {

            if(password.toLowerCase().contains(value.toLowerCase())) {
                return true;
            }
        }

        char[] charArray = password.toCharArray();

        for(int i = 0; i < charArray.length-2; i++) {

            // mindestens drei gleiche Zeichen hintereinander vorkommen?
            StringBuilder sequenzString = new StringBuilder().append(charArray[i]).append(charArray[i]).append(charArray[i]);
            if(password.contains(sequenzString.toString())) {
                return true;
            }

            // mindestens drei Zahlen fortlaufend(nur wenn Zeichen eine Zahl ist)?
            if(Character.isDigit(charArray[i])) { // ist eine Zahl?
                int number = Character.getNumericValue(charArray[i]);

                if(number < 8) { // Zahl unter 8?
                    StringBuilder verificationString = new StringBuilder().append(number).append(number+1).append(number+2);
                    if(password.contains(verificationString.toString())) { // mindestens drei fortlaufende Zahlen?
                        return true;
                    }
                }
            }

        }

        /*pattern = Pattern.compile("^[0-9]{3}+");
        matcher = pattern.matcher(password);

        if(matcher.find()) {
            return true;
        }*/


        return false;
    }
}
