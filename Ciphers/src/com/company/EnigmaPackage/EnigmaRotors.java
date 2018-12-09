package com.company.EnigmaPackage;

// Which way does it turn? lets say it just increases alphabetically
// TODO Change machine to Enigma 1 because keyboard changes
class EnigmaRotors {
    // These are mapped in alphabetical order
    //                                       "01234567890123456789012345
    static final String entryWheel =         "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String rightRotor = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
    static final int turnOverindex1 = 16;
    static int currentRightLetter;
    //                                        "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String middleRotor = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
    static final int turnOverIndex2 = 4;
    static int currentMiddleLetter;
    //                                      "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String leftRotor = "BDFHJLCPRTXVZNYEIWGAKMUSQO";

    // Use this later if I add ability to swap rotors
    // public static final int turnOverIndex3 = 21;
    // public static final String turnOver3 = "Y";


    static int currentLeftLetter;
    //                                    "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String wideBReflector = "YRUHQSLDPXNGOKMIEBFZCWVJAT";

    // Get to work one motor at a time, slowly add dont try to solve all at once
    // Decide if i want to go motor to motor or all in one step
    // TODO Fix Bug Work for negative values and wrap around
    static char evalCurrentLetter(char toEncode) {
        // index in alphabet
        // bug might be somewhere in my understanding or in the first rotor
        int toEncodeIndex = entryWheel.indexOf(toEncode);

        toEncodeIndex = entryWheel.indexOf(rightRotor.charAt((toEncodeIndex + currentRightLetter)%26)) - currentRightLetter;
        if (toEncodeIndex < 0) {
            toEncodeIndex = 26 + toEncodeIndex;
        }

        // middle rotor
        toEncodeIndex = entryWheel.indexOf(middleRotor.charAt((toEncodeIndex + currentMiddleLetter)%26)) - currentMiddleLetter;
        if (toEncodeIndex < 0) {
            toEncodeIndex = 26 + toEncodeIndex;
        }

        // left rotor
        toEncodeIndex = entryWheel.indexOf(leftRotor.charAt((toEncodeIndex + currentLeftLetter)%26)) - currentLeftLetter;
        if (toEncodeIndex < 0) {
            toEncodeIndex = 26 + toEncodeIndex;
        }

        // reflector
        toEncodeIndex = entryWheel.indexOf(wideBReflector.charAt(toEncodeIndex));

        // left again
        toEncodeIndex = leftRotor.indexOf(entryWheel.charAt((toEncodeIndex + currentLeftLetter) % 26)) - currentLeftLetter;
        if (toEncodeIndex < 0) {
            toEncodeIndex = 26 + toEncodeIndex;
        }

        // middle again
        toEncodeIndex = middleRotor.indexOf(entryWheel.charAt((toEncodeIndex + currentMiddleLetter) % 26)) - currentMiddleLetter;
        if (toEncodeIndex < 0) {
            toEncodeIndex = 26 + toEncodeIndex;
        }

        // right and final
        toEncodeIndex = rightRotor.indexOf(entryWheel.charAt((toEncodeIndex + currentRightLetter) % 26)) - currentRightLetter;
        if (toEncodeIndex < 0) {
            toEncodeIndex = 26 + toEncodeIndex;
        }

        return  entryWheel.charAt(toEncodeIndex);
    }
}
