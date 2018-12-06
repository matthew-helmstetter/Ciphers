package com.company;

import java.util.Scanner;

public class CeasarCipher {

    // Caesarian Cipher in which the individual letters are shifted
    // forward determined by the user
    // TODO make it possible to change codewords/shift lengths and add one more cipher
    // TODO change all void methods to return then create test cases
    public static String[] caesarCipher (String word, int shift) {

        // Determines how far to shift the letters
//        System.out.print("Amount shift: ");
//        int shift = Main.in.nextInt();

//        Scanner in = new Scanner(System.in);

//        System.out.print("Enter Phrase to Encode: ");
        // Allows for repeated use of same cipher
        while (true) {
//            String word = in.nextLine();
            // splits phrases by spaces to be encoded individually
            String[] split = word.split("\\s+");
            for (int x = 0; x < split.length; x++) {
                String wordToEncode = split[x];

                char[] temp = wordToEncode.toCharArray();
                // this is where the actually encoding takes places
                // 2 case, if after the shift its greater than 'z' must wrap it around
                // also works if the letter ends up below 'a' must then wrap again
                for (int i = 0; i<temp.length; i++) {
                    char letter = temp[i];
                    letter = (char) (letter + shift);

                    if (letter > 'z') {
                        letter -= (char) 26;
                    } else if (letter < 'a') {
                        letter += (char) 26;
                    }

                    temp[i] = letter;
                }
                split[x] = new String(temp);
            }
            return split;
        }
    }
}
