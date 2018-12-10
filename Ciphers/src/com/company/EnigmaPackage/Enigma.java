package com.company.EnigmaPackage;

import java.util.regex.Pattern;

// This is a model of the Enigma Machine (Enigma 1) used to encode messages
// Note on the original machine wheel turns first THEN encodes, so increase step then encode
// TODO Fix bug with turning over on the second rotor and the behavior
public class Enigma {
    public static String[] enigmaCipher (String phrase, String rotorStartingPositions) {
        // Testing for illegal arguments before continuing
        Pattern p = Pattern.compile("[^a-zA-Z ]");
        Pattern v = Pattern.compile("[^a-zA-Z]");
        if (p.matcher(phrase).find() || v.matcher(rotorStartingPositions).find() ) {
            throw new IllegalArgumentException("A non-valid character was entered.");
        }
        if (rotorStartingPositions.length() < 3) {
            throw new IllegalArgumentException("Need three starting rotor positions.");
        }
        if (phrase.isEmpty()) {
            return new String[]{};
        }

        // need to advance the rotor so it is not continuously stuck turning the next one
        boolean turnedPrevious = false;

        // Enigma code always returned in caps
        phrase = phrase.toUpperCase();
        rotorStartingPositions = rotorStartingPositions.toUpperCase();

        char[] rotorPositionsArray = rotorStartingPositions.toCharArray();
        String [] splitPhrase = phrase.split("\\s+");

        // The original ran left to right and then looped back so I did the same
        EnigmaRotors.currentRightLetter = EnigmaRotors.entryWheel.indexOf(rotorPositionsArray[2]);
        EnigmaRotors.currentMiddleLetter = EnigmaRotors.entryWheel.indexOf(rotorPositionsArray[1]);
        EnigmaRotors.currentLeftLetter = EnigmaRotors.entryWheel.indexOf(rotorPositionsArray[0]);

        // Splits phrase by spaces to allow for individual encoding
        for (int x = 0; x < splitPhrase.length; x++) {
            char[] wordToChar = splitPhrase[x].toCharArray();

            // must encode letter by letter to allow it to step through
            for (int i = 0; i < wordToChar.length; i++) {
                // Need to advance rotor 1 every call and others when it hits turnover
                if (EnigmaRotors.currentMiddleLetter == EnigmaRotors.turnOverIndex2) {
                    EnigmaRotors.currentLeftLetter++;
                    turnedPrevious = true;
                }

                if (EnigmaRotors.currentRightLetter == EnigmaRotors.turnOverindex1 || turnedPrevious) {
                    EnigmaRotors.currentMiddleLetter++;
                    turnedPrevious = false;
                }
                EnigmaRotors.currentRightLetter++;

                EnigmaRotors.currentRightLetter = (EnigmaRotors.currentRightLetter == 26) ? 0 : EnigmaRotors.currentRightLetter;
                EnigmaRotors.currentMiddleLetter = (EnigmaRotors.currentMiddleLetter == 26) ? 0 : EnigmaRotors.currentMiddleLetter;
                EnigmaRotors.currentLeftLetter = (EnigmaRotors.currentLeftLetter == 26) ? 0 : EnigmaRotors.currentLeftLetter;

                wordToChar[i] = EnigmaRotors.evalCurrentLetter(wordToChar[i]);
            }
            splitPhrase[x] = new String(wordToChar);
        }
        return splitPhrase;
    }
}
