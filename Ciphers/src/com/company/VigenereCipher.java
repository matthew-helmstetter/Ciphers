package com.company;

import java.util.regex.Pattern;

public class VigenereCipher {

    // Vigenere cipher which uses a code word to then find the
    // intersect with the inputted word on a graph of letters
    public static String[] vigenereCipher(String codeWord, String phrase){
        // Testing for illegal arguments before continuing
        Pattern p = Pattern.compile("[^a-zA-Z ]");
        if (p.matcher(codeWord).find() || p.matcher(phrase).find()) {
            throw new IllegalArgumentException("A non-valid character was entered.");
        }

        if (phrase.compareTo("") == 0) {
            return new String[]{};
        }

        int[] codeIndexArray = Utils.findIndexArrayInAlpha(codeWord.toCharArray());
        String [] splitPhrase = phrase.split("\\s+");
        char[] wordToEncodeChar;
        int[] indexOfCurrent;
        int stepCounter = 0;

        for (int x = 0; x < splitPhrase.length; x++) {
            String wordToEncode = splitPhrase[x];
            wordToEncodeChar = wordToEncode.toCharArray();
            indexOfCurrent = Utils.findIndexArrayInAlpha(wordToEncodeChar);
            // loops through every letter of each word
            for (int i = 0; i<indexOfCurrent.length; i++) {
                // this allows code words of not exact length to be used
                if (stepCounter >= codeIndexArray.length) {
                    stepCounter = i - codeIndexArray.length;
                }
                char letter = Utils.alphaMap[indexOfCurrent[i]][codeIndexArray[stepCounter]];
                wordToEncodeChar[i] = letter;
                stepCounter++;
            }
            splitPhrase[x] = new String(wordToEncodeChar);
        }
        return splitPhrase;
    }

}
