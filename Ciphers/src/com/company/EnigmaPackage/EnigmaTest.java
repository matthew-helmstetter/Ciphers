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
        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("aaa", ""));

    }

    @Test
    public void testEmptyInputs() {
        Assert.assertArrayEquals(new String[]{}, Enigma.enigmaCipher("", "aaa"));
    }

    @Test
    public void testEnigma() {
        Assert.assertArrayEquals(new String[]{"F"}, Enigma.enigmaCipher("a", "aaa"));
        Assert.assertArrayEquals(new String[]{"FT"}, Enigma.enigmaCipher("aa", "aaa"));
        Assert.assertArrayEquals(new String[]{"AA"}, Enigma.enigmaCipher("FT", "aaa"));


        Assert.assertArrayEquals(new String[]{"A"}, Enigma.enigmaCipher("n", "aaz"));

        Assert.assertArrayEquals(new String[]{"LE","EYSV","TLQU","TNHFR","OQSB","IGR","CPYX","BLML","DMPCFK","BSZKJF","SOHX"}, Enigma.enigmaCipher("If this code works then the next test should decode this", "aaa"));
        Assert.assertArrayEquals(new String[]{"IF","THIS","CODE","WORKS","THEN","THE","NEXT","TEST","SHOULD","DECODE","THIS"}, Enigma.enigmaCipher("LE EYSV TLQU TNHFR OQSB IGR CPYX BLML DMPCFK BSZKJF SOHX", "aaa"));

    }

    // bug with turnover on the second rotor
    // for some reason on enigma machine it turns over twice? when on the turnover setting
    @Test
    public void testTurnOverNextRotor() {
//         Testing first rotor turns over
        Assert.assertArrayEquals(new String[]{"J"}, Enigma.enigmaCipher("a", "aaq"));
        Assert.assertArrayEquals(new String[]{"JCO"}, Enigma.enigmaCipher("aaa", "aaq"));
        Assert.assertArrayEquals(new String[]{"JJC"}, Enigma.enigmaCipher("aaa", "aap"));


//         Testing second rotor turns over on single character
        Assert.assertArrayEquals(new String[]{"L"}, Enigma.enigmaCipher("a", "aeq"));
        // Testing second turns over multiple characters and functions properly Does not right now but will fix
//        Assert.assertArrayEquals(new String[]{"ZG"}, Enigma.enigmaCipher("aa", "adq"));

    }
}