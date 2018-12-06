package com.company;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CeasarCipher {

    // Caesarian Cipher in which the individual letters are shifted
    // forward determined by the user
    public static String[] caesarCipher (String phrase, int shift) {
        // use mod in for cases > 26 because after only remainder is the actual shift
        shift = shift%26;
        Pattern p = Pattern.compile("[^a-zA-Z0-9]");
        if (p.matcher(phrase).find()) {
            throw new IllegalArgumentException("A non-valid character was entered.");
        }
        if (phrase.compareTo("") == 0) {
            return new String[]{};
        }
        String[] splitPhrase = phrase.split("\\s+");
        String wordToEncode;
        char[] phraseToCharArr;

        // Allows for repeated use of same cipher
        while (true) {
//            String word = in.nextLine();
            // splits phrases by spaces to be encoded individually
            for (int x = 0; x < splitPhrase.length; x++) {
                wordToEncode = splitPhrase[x];

                phraseToCharArr = wordToEncode.toCharArray();
                // this is where the actually encoding takes places
                // 2 case, if after the shift its greater than 'z' must wrap it around
                // also works if the letter ends up below 'a' must then wrap again
                for (int i = 0; i<phraseToCharArr.length; i++) {
                    char letter = phraseToCharArr[i];
                    letter = (char) (letter + shift);

                    if (letter > 'z') {
                        letter -= (char) 26;
                    } else if (letter < 'a') {
                        letter += (char) 26;
                    }
                    phraseToCharArr[i] = letter;
                }
                splitPhrase[x] = new String(phraseToCharArr);
            }
            return splitPhrase;
        }
    }
}
