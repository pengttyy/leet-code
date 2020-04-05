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



    public String numberToWords(int num) {
        if(num<20){
            return NUMS[num];
        }else{
            String numStr = String.valueOf(num);
            StringBuilder sb = new StringBuilder();
            String [] num2 = new String[]{"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
            if(numStr.length()==3){
                char first = numStr.charAt(0);
                char two = numStr.charAt(1);
                int twoOffset = two - '0';
                sb.append(NUMS[first-'0']).append(" ").append("Hundred").append(" ");
                if(twoOffset!=0){
                    sb.append(num2[twoOffset-2]);
                }
                sb.append(" ").append(NUMS[(numStr.charAt(2)-'0')]);
                return sb.toString();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        char c = '1';
        System.out.println(c-'0');
    }
}
