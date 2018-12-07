package com.company.EnigmaPackage;

import java.util.regex.Pattern;

// Start of new code EnigmaPackage
// TODO literally everything
public class Enigma {
    public static String[] enigmaCipher (String phrase, String rotorPos1, String rotorPos2, String rotorPos3) {
        // Testing for illegal arguments before continuing
        Pattern p = Pattern.compile("[^a-zA-Z ]");
        if (p.matcher(phrase).find() || p.matcher(rotorPos1).find() || p.matcher(rotorPos2).find() || p.matcher(rotorPos3).find()) {
            throw new IllegalArgumentException("A non-valid character was entered.");
        }
        if (phrase.isEmpty() || rotorPos1.isEmpty() || rotorPos2.isEmpty() || rotorPos3.isEmpty()) {
            return new String[]{};
        }
        phrase = phrase.toUpperCase();
        String [] splitPhrase = phrase.split("\\s+");

        // Splits phrase by spaces to allow for individual encoding
        int totalStepCount = 0;
        for (int x = 0; x < splitPhrase.length; x++) {
            char[] wordToChar = splitPhrase[x].toCharArray();

            // must encode letter by letter to allow it to step through
            for (int i = 0; i < wordToChar.length; i++) {
                wordToChar[i] = EnigmaRotors.evalCurrentLetter(totalStepCount, wordToChar[i]);
                totalStepCount++;
            }
            splitPhrase[x] = new String(wordToChar);

        }
        return splitPhrase;
    }
}
