package com.company.EnigmaPackage;

import java.util.regex.Pattern;

// Start of new code EnigmaPackage
// TODO literally everything
// Note on the original machine wheel turns first THEN encodes, so increase step then encode
public class Enigma {
    public static String[] enigmaCipher (String phrase, String rotorStartingPositions) {
        // Testing for illegal arguments before continuing
        Pattern p = Pattern.compile("[^a-zA-Z ]");
        Pattern v = Pattern.compile("[^a-zA-Z]");

        if (p.matcher(phrase).find() || v.matcher(rotorStartingPositions).find() ) {
            throw new IllegalArgumentException("A non-valid character was entered.");
        }
        if (phrase.isEmpty() || rotorStartingPositions.isEmpty()) {
            return new String[]{};
        }

        // Enigma code always returned in caps
        phrase = phrase.toUpperCase();
        rotorStartingPositions = rotorStartingPositions.toUpperCase();

        char[] rotorPositionsArray = rotorStartingPositions.toCharArray();
        String [] splitPhrase = phrase.split("\\s+");

        EnigmaRotors.currentLetterOne = EnigmaRotors.base.indexOf(rotorPositionsArray[0]);
        EnigmaRotors.currentLetterTwo = EnigmaRotors.base.indexOf(rotorPositionsArray[1]);
        EnigmaRotors.currentLetterThree = EnigmaRotors.base.indexOf(rotorPositionsArray[2]);

        // Splits phrase by spaces to allow for individual encoding
        for (int x = 0; x < splitPhrase.length; x++) {
            char[] wordToChar = splitPhrase[x].toCharArray();

            // must encode letter by letter to allow it to step through
            for (int i = 0; i < wordToChar.length; i++) {
                // Need to advance rotor 1 every call and others when it hits turnover
                EnigmaRotors.currentLetterOne++;
                if (EnigmaRotors.currentLetterOne == EnigmaRotors.turnOverindex1) {
                    EnigmaRotors.currentLetterTwo++;
                }
                if (EnigmaRotors.currentLetterTwo == EnigmaRotors.turnOverIndex2) {
                    EnigmaRotors.currentLetterThree++;
                }

                // switch to ternary operator later
                // String mood = inProfit() ? "happy" : "sad";
                if (EnigmaRotors.currentLetterOne == 26){
                    EnigmaRotors.currentLetterOne = 0;
                }
                if (EnigmaRotors.currentLetterTwo == 26){
                    EnigmaRotors.currentLetterTwo = 0;
                }
                if (EnigmaRotors.currentLetterThree == 26){
                    EnigmaRotors.currentLetterThree = 0;
                }
                wordToChar[i] = EnigmaRotors.evalCurrentLetter(wordToChar[i]);
            }
            splitPhrase[x] = new String(wordToChar);

        }
        return splitPhrase;
    }
}
