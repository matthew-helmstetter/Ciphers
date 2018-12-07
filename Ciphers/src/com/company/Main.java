package com.company;

import com.company.Enigma.Enigma;

import java.util.Scanner;
public class Main {
    // Used for testing to print arrays of encoded words
    private static void printArray(String[] toPrint) {
        for (int i = 0; i < toPrint.length; i++) {
            System.out.println(toPrint[i]);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String phrase;
        String codeWord;
        int shift;

        while (true) {
            System.out.println("Please pick a cipher: Caesar, Vigenere, or exit");
            String cipher = in.nextLine();
            switch (cipher.toLowerCase()) {
                case "caesar":
                    System.out.println("Enter shift amount: ");
                    shift =Integer.parseInt(in.nextLine());
                    System.out.println("Enter Phrase to Encode: ");
                    phrase = in.nextLine();

                    printArray(CaesarCipher.caesarCipher(phrase, shift));
                    break;
                case "vigenere":
                    System.out.println("Enter Code Word: ");
                    codeWord = in.nextLine();

                    System.out.println("Enter Phrase to Encode: ");
                    phrase = in.nextLine();
                    printArray(VigenereCipher.vigenereCipher(codeWord, phrase));
                    break;
                case "enigma":
                    Enigma.enigmaCipher("a", "1","1","1");
                case "exit":
                    in.close();
                    System.exit(0);
                default:
                    System.out.println("Not a supported cipher");
            }
        }
    }
}
