package com.company.EnigmaPackage;

public class EnigmaRotors {
    // These are mapped in alphabetical order
    public static final String base =   "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String rotor1 = "JGDQOXUSCAMIFRVTPNEWKBLZYH";
    public static final int turnOverindex1 = 17;
    public static final String turnOver1 = "N";

    //                                  "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String rotor2 = "NTZPSFBOKMWRCJDIVLAEYUXHGQ";
    public static final int turnOverIndex2 = 19;
    public static final String turnOver2 = "E";

    //                                  "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String rotor3 = "JVIUBHTCDYAKEQZPOSGXNRMWFL";
    public static final int turnOverIndex3 = 9;
    public static final String turnOver3 = "Y";

    //                                   "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String reflect = "QYHOGNECVPUZTFDJAXWMKISRBL";

    // Get to work one motor at a time, slowly add dont try to solve all at once
    // Decide if i want to go motor to motor or all in one step
    public static char evalCurrentLetter(int indexOfCharInWord, char toEncode) {
        char firstPass = rotor1.charAt(indexOfCharInWord + base.indexOf(toEncode));
        char reflectChar = reflect.charAt(base.indexOf(firstPass));
        char secondPass = rotor1.charAt(base.indexOf(reflectChar));
        return secondPass;
    }

}
