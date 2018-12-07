package com.company.CipherTests;

import com.company.VigenereCipher;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VigenereCipherTest {

    @Test
    public void testEmptyVigenereCipher() {
        Assert.assertArrayEquals(new String[]{}, VigenereCipher.vigenereCipher("", ""));
        assertArrayEquals(new String[]{}, VigenereCipher.vigenereCipher("a", ""));
    }

    @Test
    public void testActualCipher() {
        assertArrayEquals(new String[]{"bda"}, VigenereCipher.vigenereCipher("bold", "app"));
    }

    @Test (expected=IllegalArgumentException.class)
    public void testIllegalCharacters() {
        VigenereCipher.vigenereCipher("?", "a");
        VigenereCipher.vigenereCipher("a", "?");
        VigenereCipher.vigenereCipher("1", "?");
        VigenereCipher.vigenereCipher("a", "2");
        VigenereCipher.vigenereCipher("1", "2");
    }

    @Test
    public void testFindIndexArrayInAlpha() {
    }
}