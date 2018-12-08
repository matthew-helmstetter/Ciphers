package com.company.EnigmaPackage;

import org.junit.Assert;
import org.junit.Test;

public class EnigmaTest {
    @Test (expected=IllegalArgumentException.class)
    public void testIllegealArguments() {
        Enigma.enigmaCipher("1", "aab");
        Enigma.enigmaCipher("a", "!");
        Enigma.enigmaCipher("!$", "aab");
        Enigma.enigmaCipher("a", "aa");
        Enigma.enigmaCipher("a", "");
    }

    @Test
    public void testEmptyInputs() {
        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("", ""));
        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("", "aaa"));
        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("aaa", ""));

    }

    @Test
    public void testEnigma() {
        // Path is: AJMEGTEO
        Assert.assertArrayEquals(new String[]{"N"}, Enigma.enigmaCipher("a", "aaz"));
        // Path is:   OVUNFHO
        // should be: OETGEMJA

        Assert.assertArrayEquals(new String[]{"A"}, Enigma.enigmaCipher("n", "aaz"));

        Assert.assertArrayEquals(new String[]{"I"}, Enigma.enigmaCipher("r", "aaz"));
        Assert.assertArrayEquals(new String[]{"R"}, Enigma.enigmaCipher("i", "aaz"));


//        Assert.assertArrayEquals(new String[]{"OP"}, Enigma.enigmaCipher("aa", "aaz"));
//        Assert.assertArrayEquals(new String[]{"O", "P"}, Enigma.enigmaCipher("a a", "aaz"));
//        // Enigma should be able to decipher just be re-entering the encrypted message with same starting settings
//        Assert.assertArrayEquals(new String[]{"RM","XSVY","OMRNC","WC","ANQTBW","QXMB","TDHFSO"}, Enigma.enigmaCipher("If this works it should also decode", "aaa"));
//        Assert.assertArrayEquals(new String[]{"IF","THIS","WORKS","IT","SHOULD","ALSO","DECODE"}, Enigma.enigmaCipher("RM XSVY OMRNC WC ANQTBW QXMB TDHFSO", "aaa"));

    }

    @Test
    public void testTurnOverNextRotor() {
        Assert.assertArrayEquals(new String[]{"M"}, Enigma.enigmaCipher("a", "aaq"));
        Assert.assertArrayEquals(new String[]{"L"}, Enigma.enigmaCipher("a", "asq"));

    }
}