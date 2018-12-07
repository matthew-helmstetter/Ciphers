package com.company.EnigmaPackage;

// Which way does it turn? lets say it just increases alphabetically
public class EnigmaRotors {
    // These are mapped in alphabetical order
    public static final String base =   "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

//                                      "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String rotor1 = "JGDQOXUSCAMIFRVTPNEWKBLZYH";
    public static final int turnOverindex1 = 17;
    public static final String turnOver1 = "N";
    public static int currentLetterOne;

    //                                  "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String rotor2 = "NTZPSFBOKMWRCJDIVLAEYUXHGQ";
    public static final int turnOverIndex2 = 19;
    public static final String turnOver2 = "E";
    public static int currentLetterTwo;


    //                                  "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String rotor3 = "JVIUBHTCDYAKEQZPOSGXNRMWFL";
    public static final int turnOverIndex3 = 9;
    public static final String turnOver3 = "Y";
    public static int currentLetterThree;


    //                                   "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String reflect = "QYHOGNECVPUZTFDJAXWMKISRBL";

    // AA - T

    // Get to work one motor at a time, slowly add dont try to solve all at once
    // Decide if i want to go motor to motor or all in one step
    // TODO make it work from a set rotor position
    public static char evalCurrentLetter(char toEncode) {

        // index in alphabet
        int toEncodeIndex = base.indexOf(toEncode);
        // 1st rotor
        toEncodeIndex = indexAfterRotor(toEncodeIndex, rotor1);
        //2nd rotor
        toEncodeIndex = indexAfterRotor(toEncodeIndex, rotor2);
        // 3rd rotor
        toEncodeIndex = indexAfterRotor(toEncodeIndex, rotor3);

        //reflector
        toEncodeIndex = indexAfterRotor(toEncodeIndex, reflect);

        //3rd again
        toEncodeIndex = indexAfterRotor(toEncodeIndex, rotor3);

        // 2nd again
        toEncodeIndex = indexAfterRotor(toEncodeIndex, rotor2);


        // 1st and final
        return  rotor1.charAt(toEncodeIndex);
    }

    private static int indexAfterRotor (int toEncodeIndex, String rotor) {
        char temp = rotor.charAt(toEncodeIndex);
        return  base.indexOf(temp);
    }

}
