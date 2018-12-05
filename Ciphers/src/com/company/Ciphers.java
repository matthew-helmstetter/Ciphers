package com.company;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
public class Ciphers {
    // Caesarian Cipher in which the individual letters are shifted
    // forward determined by the user
    // TODO make it possible to change codewords/shift lengths and add one more cipher
    // TODO change all void methods to return then create test cases 
    public static void caesarCipher () {
        Scanner in = new Scanner(System.in);

        // Determines how far to shift the letters
        System.out.print("Amount shift: ");
        int shift = in.nextInt();
        System.out.print("Enter Phrases to Encode, Enter 'back' When Finished: ");
        // Allows for repeated use of same cipher
        // TODO add a way to go back to choosing cipher
        while (true) {
            String word = in.nextLine();
            if (word.toLowerCase().compareTo("back") == 0) {
                break;
            }
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
                String solution = new String(temp);
                System.out.print(solution + ' ');
            }
            System.out.println();
        }
    }

    // Vigenere cipher which uses a code word to then find the
    // intersect with the inputted word on a graph of letters
    public static void vigenereCipher(){
        Scanner in = new Scanner(System.in);
        char[][] alphaMap = {
            {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'},
            {'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a'},
            {'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b'},
            {'d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c'},
            {'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd'},
            {'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e'},
            {'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f'},
            {'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g'},
            {'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'},
            {'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'},
            {'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'},
            {'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'},
            {'m', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l'},
            {'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm'},
            {'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n'},
            {'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o'},
            {'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p'},
            {'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q'},
            {'s', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r'},
            {'t', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's'},
            {'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't'},
            {'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u'},
            {'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v'},
            {'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w'},
            {'y', 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x'},
            {'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y'}};

            System.out.print("Please enter a code word: ");
            String codeWord = in.next();
            char[] codeWordArray = codeWord.toCharArray();
            int[] codeIndexArray = findIndexArrayInAlpha(codeWordArray);
            System.out.print("Enter Phrases to Encode: ");
        // TODO Make it so it repeats the code word and can word with any length of phrase
        // test more but may work now
        while (true) {
            String word = in.nextLine();
            // splits phrase on spaces
            String[] split = word.split("\\s+");
            // loops through every word in phrase
            for (int x = 0; x < split.length; x++) {
                String wordToEncode = split[x];
                char[] temp = wordToEncode.toCharArray();
                int[] indexOfCurrent = findIndexArrayInAlpha(temp);
                // loops through every letter of each word
                for (int i = 0; i<indexOfCurrent.length; i++) {
                    int codeIndex = i;
                    if (i >= codeIndexArray.length) {
                        codeIndex = i - codeIndexArray.length;
                    }
                    char letter = alphaMap[indexOfCurrent[i]][codeIndexArray[codeIndex]];
                    temp[i] = letter;
                }
                String solution = new String(temp);
                System.out.print(solution + ' ');
            }
            System.out.println();
        }
    }

    public static int[] findIndexArrayInAlpha (char[] codeArray) {
        String shortcut = "abcdefghijklmnopqrstuvwxyz";
        int[] indexArray = new int[codeArray.length];
        for (int i=0; i<codeArray.length; i++) {
            indexArray[i] = shortcut.indexOf(codeArray[i]);
        }
        return indexArray;
    }

    public static void printArray (int[] array) {
        for (int i=0; i<array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Please pick a cipher: Caesar, Vigenere, or exit");
            String cipher = in.next();
            switch (cipher.toLowerCase()) {
                case "caesar":
                    caesarCipher();
                    break;
                case "vigenere":
                    vigenereCipher();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Not a supported cipher");
            }
        }
    }
}
