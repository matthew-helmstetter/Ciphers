package com.company.Enigma;

import java.util.regex.Pattern;

// Start of new code Enigma
// TODO literally everything
public class Enigma {
    public static String[] enigmaCipher (String phrase, String motor1, String motor2, String motor3) {
        // Testing for illegal arguments before continuing
        Pattern p = Pattern.compile("[^a-zA-Z]");
        if (p.matcher(phrase).find()) {
            throw new IllegalArgumentException("A non-valid character was entered.");
        }
        try {
            int motor1Position = Integer.parseInt(motor1);
            int motor2Position = Integer.parseInt(motor2);
            int motor3Position = Integer.parseInt(motor3);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("A non-valid character was entered.");
        }

        if (phrase.compareTo("") == 0) {
            return new String[]{};
        }
        return new String[]{};
    }
}
