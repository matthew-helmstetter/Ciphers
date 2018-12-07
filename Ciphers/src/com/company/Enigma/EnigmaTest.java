package com.company.Enigma;

import com.company.CaesarCipher;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnigmaTest {

    @Test (expected=IllegalArgumentException.class)
    public void testIllegealArguments() {
        assertEquals(IllegalArgumentException.class, Enigma.enigmaCipher("1", "1","1", "1"));
    }
}