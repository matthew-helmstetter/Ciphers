package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class CeasarTest {

   @Test
    public void testEmptyPhrase() {
       assertArrayEquals(new String[]{}, CeasarCipher.caesarCipher("", 0));
    }

    @Test
    public void testLargeShift() {
        assertArrayEquals(new String[]{"a"}, CeasarCipher.caesarCipher("a", 26));
        assertArrayEquals(new String[]{"b"}, CeasarCipher.caesarCipher("a", 27));
        assertArrayEquals(new String[]{"ghijkl"}, CeasarCipher.caesarCipher("abcdef", 500));
    }

    @Test
    public void testNegativeShift() {
        assertArrayEquals(new String[]{"z"}, CeasarCipher.caesarCipher("a", -1));
        assertArrayEquals(new String[]{"uvwxyz"}, CeasarCipher.caesarCipher("abcdef", -500));
    }

    @Test (expected=IllegalArgumentException.class)
    public void testSpecialCharacters() {
        assertEquals(IllegalArgumentException.class, CeasarCipher.caesarCipher("?", 1));
    }


}