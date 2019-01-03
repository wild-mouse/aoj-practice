package com.example.itp1.three;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class HowManyDivisors {
    private static int MAX = 10000;
    private static int MIN = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a > b || a > MAX || a < MIN || b > MAX || b < MIN
                    || c > MAX || c < MIN) {
                throw new InvalidTestCaseException("Condition is invalid.");
            }
            System.out.println(IntStream.rangeClosed(a, b)
                    .filter(i -> c % i == 0)
                    .count());
        } catch (InvalidTestCaseException
                | NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    static class InvalidTestCaseException extends RuntimeException {
        InvalidTestCaseException(String m) {
            super(m);
        }
    }
}

