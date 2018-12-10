package com.company.EnigmaPackage;

// This acts as the rotors in the Enigma machine and steps through the wiring and returns the encoded letter
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
        int toEncodeIndex = entryWheel.indexOf(toEncode);

        // right rotor
        toEncodeIndex = stepThroughRotor(toEncodeIndex, currentRightLetter, rightRotor, 0);
        toEncodeIndex = (toEncodeIndex < 0) ? 26 + toEncodeIndex : toEncodeIndex;

        // middle rotor
        toEncodeIndex = stepThroughRotor(toEncodeIndex, currentMiddleLetter, middleRotor, 0);
        toEncodeIndex = (toEncodeIndex < 0) ? 26 + toEncodeIndex : toEncodeIndex;

        // left rotor
        toEncodeIndex = stepThroughRotor(toEncodeIndex, currentLeftLetter, leftRotor, 0);
        toEncodeIndex = (toEncodeIndex < 0) ? 26 + toEncodeIndex : toEncodeIndex;

        // reflector
        toEncodeIndex = stepThroughRotor(toEncodeIndex, 0, wideBReflector, 0);

        // Start of Pass 2 going through the rotors backwards
        // left again
        toEncodeIndex = stepThroughRotor(toEncodeIndex, currentLeftLetter, leftRotor, 1);
        toEncodeIndex = (toEncodeIndex < 0) ? 26 + toEncodeIndex : toEncodeIndex;

        // middle again
        toEncodeIndex = stepThroughRotor(toEncodeIndex, currentMiddleLetter, middleRotor, 1);
        toEncodeIndex = (toEncodeIndex < 0) ? 26 + toEncodeIndex : toEncodeIndex;

        // right and final
        toEncodeIndex = stepThroughRotor(toEncodeIndex, currentRightLetter, rightRotor, 1);
        toEncodeIndex = (toEncodeIndex < 0) ? 26 + toEncodeIndex : toEncodeIndex;

        return  entryWheel.charAt(toEncodeIndex);
    }
    private static int stepThroughRotor (int toEncodeIndex, int currentLetter, String rotor, int pass) {
        if (pass == 0) {
            toEncodeIndex = entryWheel.indexOf(rotor.charAt((toEncodeIndex + currentLetter)%26)) - currentLetter;
        } else {
            toEncodeIndex = rotor.indexOf(entryWheel.charAt((toEncodeIndex + currentLetter) % 26)) - currentLetter;
        }
        return toEncodeIndex;
    }
}
