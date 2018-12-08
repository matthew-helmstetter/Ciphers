package com.company.EnigmaPackage;

// Which way does it turn? lets say it just increases alphabetically
class EnigmaRotors {
    // These are mapped in alphabetical order
    //                               "01234567890123456789012345
    static final String base =       "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String rightRotor = "JGDQOXUSCAMIFRVTPNEWKBLZYH";
    static final int turnOverindex1 = 17;
    static int currentRightLetter;
    //                                "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String middleRotor = "NTZPSFBOKMWRCJDIVLAEYUXHGQ";
    static final int turnOverIndex2 = 19;
    static int currentMiddleLetter;
    //                              "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String leftRotor = "JVIUBHTCDYAKEQZPOSGXNRMWFL";

    // Use this later if I add ability to swap rotors
    // public static final int turnOverIndex3 = 9;
    // public static final String turnOver3 = "Y";

    static int currentLeftLetter;
    //                            "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String reflect = "QYHOGNECVPUZTFDJAXWMKISRBL";

    // Get to work one motor at a time, slowly add dont try to solve all at once
    // Decide if i want to go motor to motor or all in one step
    // TODO make it work from a set rotor position
    static char evalCurrentLetter(char toEncode) {
        // index in alphabet
        int toEncodeIndex = base.indexOf(toEncode);
        // right rotor
        toEncodeIndex = base.indexOf(rightRotor.charAt((toEncodeIndex + currentRightLetter)%26));
        // middle rotor
        toEncodeIndex = base.indexOf(middleRotor.charAt((toEncodeIndex + currentMiddleLetter)%26));
        // left rotor
        toEncodeIndex = base.indexOf(leftRotor.charAt((toEncodeIndex + currentLeftLetter)%26));
        // reflector
        toEncodeIndex = base.indexOf(reflect.charAt(toEncodeIndex));
        // left again
        toEncodeIndex = base.indexOf(leftRotor.charAt((toEncodeIndex + currentLeftLetter)%26));
        // middle again
        toEncodeIndex = base.indexOf(middleRotor.charAt((toEncodeIndex + currentMiddleLetter)%26));
        // right and final
        return  rightRotor.charAt((toEncodeIndex + currentRightLetter)%26);
    }
}
