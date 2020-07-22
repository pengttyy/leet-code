package com.object.leetcode.t273;

public class Solution273_1 {

    final static String[] zeroToNineteen = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final static String[] twentyToNinety = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    final int BILLION = 1000000000;
    final int MILLION = 1000000;
    final int THOUSAND = 1000;
    final int HUNDRED = 100;

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder builder = new StringBuilder();
        if (num >= BILLION) {
            if (builder.length() != 0) builder.append(" ");
            builder.append(numberToWords(num / BILLION)).append(" Billion");
            num %= BILLION;
        }
        if (num >= MILLION) {
            if (builder.length() != 0) builder.append(" ");
            builder.append(numberToWords(num / MILLION)).append(" Million");
            num %= MILLION;
        }
        if (num >= THOUSAND) {
            if (builder.length() != 0) builder.append(" ");
            builder.append(numberToWords(num / THOUSAND)).append(" Thousand");
            num %= THOUSAND;
        }
        if (num >= HUNDRED) {
            if (builder.length() != 0) builder.append(" ");
            builder.append(numberToWords(num / HUNDRED)).append(" Hundred");
            num %= HUNDRED;
        }
        if (num < 20) {
            if (num != 0) {
                if (builder.length() != 0) builder.append(" ");
                builder.append(zeroToNineteen[num]);
            }
        } else {
            if (builder.length() != 0) builder.append(" ");
            builder.append(twentyToNinety[num / 10 - 2]);
            if (num % 10 != 0) {
                if (builder.length() != 0) builder.append(" ");
                builder.append(zeroToNineteen[num % 10]);
            }
        }
        return builder.toString();
    }


}
