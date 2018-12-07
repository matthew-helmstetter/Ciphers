package com.company.EnigmaPackage;

import org.junit.Assert;
import org.junit.Test;

public class EnigmaTest {

    @Test (expected=IllegalArgumentException.class)
    public void testIllegealArguments() {
        Enigma.enigmaCipher("1", "a","a", "a");
        Enigma.enigmaCipher("1", "1","a", "a");
        Enigma.enigmaCipher("1", "1","1", "a");
        Enigma.enigmaCipher("1", "1","1", "1");
        Enigma.enigmaCipher("aa1vvd", "1","1", "1");
    }

    @Test
    public void testEmptyPhrase() {
        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("", "a","a", "a"));
        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("", "", "", ""));
        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("a", "", "a", "a"));
        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("a", "a", "", "a"));
        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("a", "a", "a", ""));
    }

    @Test
    public void testEnigma() {
        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("a", "a","a", "a"));
    }
}