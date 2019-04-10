package com.ercargo.learn.concurrency.algrithm;

/**
 * @author ercargo  on 2019/4/10
 * @DESCRIBE
 */
public class StringReverse {

    public static String reverse(String s) {
        /*String reverse = "";
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            reverse += arr[i];
        }
        return reverse;*/


       /* String reverse = "";
        for (int i = s.length()-1; i >= 0; i--) {
            reverse = reverse + s.charAt(i);
        }
        return reverse;*/


        char[] arr = s.toCharArray();
        String reverse = "";
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
            reverse = arr[i] + reverse;
        }

        return reverse;


    }


    public static String reverse2(String s2) {
        int length = s2.length();
        String reverse = "";
        for (int i = 0; i < s2.length(); i++) {
            reverse = s2.charAt(i) + reverse;
        }
        return reverse;
    }


    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverse(s));
        System.out.println(reverse2(s));
    }
}
