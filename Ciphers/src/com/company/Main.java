package com.company;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
public class Main {
    public static Scanner in = new Scanner(System.in);


    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Please pick a cipher: Caesar, Vigenere, or exit");
            String cipher = in.next();
            switch (cipher.toLowerCase()) {
                case "caesar":
                    CeasarCipher.caesarCipher();
                    break;
                case "vigenere":
                    VigenereCipher.vigenereCipher();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Not a supported cipher");
            }
        }
    }
}
