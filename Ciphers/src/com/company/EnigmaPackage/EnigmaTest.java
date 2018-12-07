package com.company.EnigmaPackage;

import org.junit.Assert;
import org.junit.Test;

public class EnigmaTest {

    @Test (expected=IllegalArgumentException.class)
    public void testIllegealArguments() {
        Enigma.enigmaCipher("1", "aaa");
    }

//    @Test
//    public void testEmptyPhrase() {
//        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("", "a","a", "a"));
//        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("", "", "", ""));
//        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("a", "", "a", "a"));
//        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("a", "a", "", "a"));
//        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("a", "a", "a", ""));
//    }

    @Test
    public void testEnigma() {
        Assert.assertArrayEquals(new String[]{"O"}, Enigma.enigmaCipher("a", "aaa"));
    }
}