package com.object.leetcode;

/**
 * Hello world!
 *
 * @author kai.peng
 */
public class Solution273 {

    private static final String[] NUMS = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"
    };

    private static final String[] NUM2 = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] UNIT = new String[]{"", "", "Thousand", "Million", "Billion", "Trillion"};

    public static final int TWENTY = 20;
    public static final int ONE_HUNDRED = 100;
    public static final String HUNDRED = "Hundred";
    public static final String SPACE = " ";


    public String numberToWords(int num) {
        if(num==0){
            return NUMS[0];
        }
        StringBuilder sb = new StringBuilder();
        String iStr = String.valueOf(num);
        int length = iStr.length();
        int count = length / 3;
        int remainder = length % 3;
        count = remainder != 0 ? count + 1 : count;
        int index = 0;
        for (int j = count; j >= 1; j--) {
            if (j == count && remainder != 0) {
                String numSegment = iStr.substring(index, remainder);
                sb.append(segment(Integer.parseInt(numSegment)))
                        .append(SPACE)
                        .append(UNIT[j]);
                index = remainder;
            } else {
                int endIndex = index + 3;
                String numSegment = iStr.substring(index, endIndex);

                int num1 = Integer.parseInt(numSegment);
                if (num1!=0) {
                    sb.append(SPACE)
                            .append(segment(num1))
                            .append(SPACE)
                            .append(UNIT[j]);
                }
                index = endIndex;
            }
        }

        return sb.toString().trim();
    }

    private String segment(int num) {
        if (num == 0) {
            return "";
        }

        if (num < TWENTY) {
            return NUMS[num];
        } else if (num >= TWENTY && num < ONE_HUNDRED) {
            return twoNum(num);
        } else {
            int hundreds = num / ONE_HUNDRED;
            return (NUMS[hundreds] + SPACE + HUNDRED + SPACE + this.twoNum(num % ONE_HUNDRED)).trim();
        }
    }

    public String twoNum(int num) {
        if (num == 0) {
            return "";
        }
        if (num < TWENTY) {
            return NUMS[num];
        }
        String tenOffset = NUM2[num / 10 - 2];
        int unit = num % 10;
        if (unit == 0) {
            return tenOffset;
        } else {
            return tenOffset + SPACE + NUMS[unit];
        }
    }

    public static void main(String[] args) {
        System.out.println(2 % 3);
    }
}
