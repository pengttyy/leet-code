package com.object.leetcode.t273;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.object.leetcode.t273.Solution273;
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
    public void testLessThan20() {
        assertEqualsNumber(5, "Five");
        assertEqualsNumber(0, "Zero");
        assertEqualsNumber(15, "Fifteen");
    }

    private void assertEqualsNumber(int i, String five) {
        String words = this.solution273.numberToWords(i);
        assertEquals(five, words);
    }

    @Test
    public void test_20_100() {
        assertEqualsNumber(20, "Twenty");
        assertEqualsNumber(99, "Ninety Nine");
    }

    @Test
    public void test_100_999() {
        assertEqualsNumber(123, "One Hundred Twenty Three");
        assertEqualsNumber(100, "One Hundred");
        assertEqualsNumber(101, "One Hundred One");
    }

    @Test
    public void test_1000() {
        assertEqualsNumber(1000, "One Thousand");
    }

    @Test
    public void test_12345() {
        assertEqualsNumber(12345, "Twelve Thousand Three Hundred Forty Five");
    }

    @Test
    public void test_100000() {
        assertEqualsNumber(100000, "One Hundred Thousand");
    }

    @Test
    public void test_1234567() {
        assertEqualsNumber(1234567, "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven");
        assertEqualsNumber(1000000, "One Million");
    }

}
