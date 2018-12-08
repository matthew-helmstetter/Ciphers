package com.company.EnigmaPackage;

import org.junit.Assert;
import org.junit.Test;

public class EnigmaTest {
    @Test (expected=IllegalArgumentException.class)
    public void testIllegealArguments() {
        Enigma.enigmaCipher("1", "aab");
        Enigma.enigmaCipher("a", "aa");
    }

    @Test
    public void testEmptyInputs() {
        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("", ""));
        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("", "aaa"));
        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("aaa", ""));
    }

    @Test
    public void testEnigma() {
        Assert.assertArrayEquals(new String[]{"P"}, Enigma.enigmaCipher("a", "aaa"));
        Assert.assertArrayEquals(new String[]{"OP"}, Enigma.enigmaCipher("aa", "aaz"));
        Assert.assertArrayEquals(new String[]{"O", "P"}, Enigma.enigmaCipher("a a", "aaz"));
    }

    @Test
    public void testTurnOverNextRotor() {
        Assert.assertArrayEquals(new String[]{"M"}, Enigma.enigmaCipher("a", "aaq"));
        Assert.assertArrayEquals(new String[]{"L"}, Enigma.enigmaCipher("a", "asq"));

    }
}