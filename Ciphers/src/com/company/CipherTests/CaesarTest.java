package com.company.CipherTests;

import com.company.CaesarCipher;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CaesarTest {

   @Test
    public void testEmptyPhrase() {
       Assert.assertArrayEquals(new String[]{}, CaesarCipher.caesarCipher("", 0));
    }

    @Test
    public void testLargeShift() {
        assertArrayEquals(new String[]{"a"}, CaesarCipher.caesarCipher("a", 26));
        assertArrayEquals(new String[]{"b"}, CaesarCipher.caesarCipher("a", 27));
        assertArrayEquals(new String[]{"ghijkl"}, CaesarCipher.caesarCipher("abcdef", 500));
    }

    @Test
    public void testNegativeShift() {
        assertArrayEquals(new String[]{"z"}, CaesarCipher.caesarCipher("a", -1));
        assertArrayEquals(new String[]{"uvwxyz"}, CaesarCipher.caesarCipher("abcdef", -500));
    }

    @Test (expected=IllegalArgumentException.class)
    public void testSpecialCharacters() {
        assertEquals(IllegalArgumentException.class, CaesarCipher.caesarCipher("?", 1));
    }

    @Test
    public void testWithSpace() {
        assertArrayEquals(new String[]{"b", "b"}, CaesarCipher.caesarCipher("a a", 1));
        assertArrayEquals(new String[]{"z", "z"}, CaesarCipher.caesarCipher("a a", -1));


    }


}