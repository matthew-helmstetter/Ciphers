package com.company;

import com.company.EnigmaPackage.Enigma;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String phrase;
        String codeWord;
        String rotorPositions;
        int shift;

        while (true) {
            System.out.println("Please pick a cipher: Caesar, Vigenere, Enigma, or exit");
            String cipher = in.nextLine();
            switch (cipher.toLowerCase()) {
                case "caesar":
                    System.out.println("Enter shift amount: ");
                    shift =Integer.parseInt(in.nextLine());
                    System.out.println("Enter Phrase to Encode: ");
                    phrase = in.nextLine();
                    Utils.printArray(CaesarCipher.caesarCipher(phrase, shift));
                    break;

                case "vigenere":
                    System.out.println("Enter Code Word: ");
                    codeWord = in.nextLine();

                    System.out.println("Enter Phrase to Encode: ");
                    phrase = in.nextLine();
                    Utils.printArray(VigenereCipher.vigenereCipher(codeWord, phrase));
                    break;

                case "enigma":
                    System.out.println("Enter Starting Position of Rotors (i.e. abd, tre): ");
                    rotorPositions = in.nextLine();
                    System.out.println("Enter Phrase to Encode: ");
                    phrase = in.nextLine();
                    Utils.printArray(Enigma.enigmaCipher(phrase, rotorPositions));

                case "exit":
                    in.close();
                    System.exit(0);

                default:
                    System.out.println("Not a supported cipher");
            }
        }
    }
}
