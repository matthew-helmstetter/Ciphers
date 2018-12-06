package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class VigenereCipherTest {

    @Test
    public void testEmptyVigenereCipher() {
        assertArrayEquals(new String[]{}, VigenereCipher.vigenereCipher("", ""));
        assertArrayEquals(new String[]{}, VigenereCipher.vigenereCipher("a", ""));

    }

    @Test
    public void testActualCipher() {
        assertArrayEquals(new String[]{"bda"}, VigenereCipher.vigenereCipher("bold", "app"));
    }

    @Test (expected=IllegalArgumentException.class)
    public void testIllegalCharacters() {
        assertEquals(IllegalArgumentException.class, VigenereCipher.vigenereCipher("?", "a"));
        assertEquals(IllegalArgumentException.class, VigenereCipher.vigenereCipher("a", "?"));
        assertEquals(IllegalArgumentException.class, VigenereCipher.vigenereCipher("1", "?"));
        assertEquals(IllegalArgumentException.class, VigenereCipher.vigenereCipher("a", "2"));
    }

    @Test
    public void testFindIndexArrayInAlpha() {
    }
}