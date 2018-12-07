package com.company.EnigmaPackage;

import java.util.regex.Pattern;

// Start of new code EnigmaPackage
// TODO literally everything
public class Enigma {
    public static String[] enigmaCipher (String phrase, String motorPos1, String motorPos2, String motorPos3) {
        // Testing for illegal arguments before continuing
        Pattern p = Pattern.compile("[^a-zA-Z ]");
        if (p.matcher(phrase).find() || p.matcher(motorPos1).find() || p.matcher(motorPos2).find() || p.matcher(motorPos3).find()) {
            throw new IllegalArgumentException("A non-valid character was entered.");
        }
        if (phrase.isEmpty() || motorPos1.isEmpty() || motorPos2.isEmpty() || motorPos3.isEmpty()) {
            return new String[]{};
        }

        return new String[]{"a"};
    }
}
