package com.company.Enigma;

import java.util.regex.Pattern;

// Start of new code Enigma
// TODO literally everything
public class Enigma {
    public static String[] enigmaCipher (String phrase, String motor1, String motor2, String motor3) {
        // Testing for illegal arguments before continuing
        Pattern p = Pattern.compile("[^a-zA-Z ]");
        if (p.matcher(phrase).find() || p.matcher(motor1).find() || p.matcher(motor2).find() || p.matcher(motor3).find()) {
            throw new IllegalArgumentException("A non-valid character was entered.");
        }
        if (phrase.isEmpty() || motor1.isEmpty() || motor2.isEmpty() || motor3.isEmpty()) {
            return new String[]{};
        }


        return new String[]{"a"};
    }
}
