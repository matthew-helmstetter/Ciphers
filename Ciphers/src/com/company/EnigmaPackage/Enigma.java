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

        boolean temp = false;

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
                EnigmaRotors.currentRightLetter++;
                if (EnigmaRotors.currentRightLetter == EnigmaRotors.turnOverindex1) {
                    EnigmaRotors.currentMiddleLetter++;
                }

                if (EnigmaRotors.currentMiddleLetter == EnigmaRotors.turnOverIndex2) {
                    EnigmaRotors.currentLeftLetter++;
                    temp = true;
                }
                // switch to ternary operator later
                // String mood = inProfit() ? "happy" : "sad";
                if (EnigmaRotors.currentRightLetter == 26){
                    EnigmaRotors.currentRightLetter = 0;
                }
                if (EnigmaRotors.currentMiddleLetter == 26){
                    EnigmaRotors.currentMiddleLetter = 0;
                }
                if (EnigmaRotors.currentLeftLetter == 26){
                    EnigmaRotors.currentLeftLetter = 0;
                }
                wordToChar[i] = EnigmaRotors.evalCurrentLetter(wordToChar[i]);
//                if (temp) {
//                    EnigmaRotors.currentMiddleLetter++;
//                    temp = false;
//                }
            }
            splitPhrase[x] = new String(wordToChar);
        }
//        System.out.println(EnigmaRotors.currentRightLetter);
//        System.out.println(EnigmaRotors.currentMiddleLetter);
//        System.out.println(EnigmaRotors.currentLeftLetter);

        return splitPhrase;
    }
}
