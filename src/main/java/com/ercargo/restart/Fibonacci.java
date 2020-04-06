package com.ercargo.restart;

/**
 * @author ercargo  on 2020/4/5
 * @DESCRIBE
 * 0，1，1，2，3，5，8，13...
 * F(0) = 0
 * F(1) = 1
 * F(n) = F(n-1) + F(n-2)
 * e.g：
 * F(2) = F(1) + F(0) = 1
 * F(3) = F(2) + F(1) = 2
 */
public class Fibonacci {

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(9));

        System.out.println(fib(10000000));
    }
}
