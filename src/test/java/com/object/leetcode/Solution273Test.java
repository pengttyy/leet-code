package com.object.leetcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class Solution273Test {

    private Solution273 solution273;

    @Before
    public void setUp() {
        this.solution273 = new Solution273();
    }

    @Test
    public void shouldAnswerWithTrue() {
        String words = this.solution273.numberToWords(5);
        assertEquals("Five", words);
        words = this.solution273.numberToWords(15);
        assertEquals("Fifteen", words);
//        words = this.solution273.numberToWords(25);
//        assertEquals("Twenty Five",words);

        words = this.solution273.numberToWords(125);
        System.out.println(words);
    }
}
