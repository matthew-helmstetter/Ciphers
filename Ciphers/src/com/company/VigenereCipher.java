package com.company;

import java.util.regex.Pattern;

public class VigenereCipher {

    // Vigenere cipher which uses a code word to then find the
    // intersect with the inputted word on a graph of letters
    public static String[] vigenereCipher(String codeWord, String phrase){

        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
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

        while (true) {
            // loops through every word in phrase
            for (int x = 0; x < splitPhrase.length; x++) {
                String wordToEncode = splitPhrase[x];
                wordToEncodeChar = wordToEncode.toCharArray();
                indexOfCurrent = Utils.findIndexArrayInAlpha(wordToEncodeChar);
                // loops through every letter of each word
                for (int i = 0; i<indexOfCurrent.length; i++) {
                    int codeIndex = i;
                    if (i >= codeIndexArray.length) {
                        codeIndex = i - codeIndexArray.length;
                    }
                    char letter = Utils.alphaMap[indexOfCurrent[i]][codeIndexArray[codeIndex]];
                    wordToEncodeChar[i] = letter;
                }
                splitPhrase[x] = new String(wordToEncodeChar);
            }
            return splitPhrase;
        }
    }

}
