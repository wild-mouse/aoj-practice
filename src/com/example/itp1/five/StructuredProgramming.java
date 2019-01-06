package com.example.itp1.five;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class StructuredProgramming {
    private static int MAX = 10_000;
    private static int MIN = 3;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            if (n > MAX || n < MIN) {
                throw new IllegalTestCaseException();
            }
            for (int i = 1; i <= n; i++) {
                int x = i;
                if (checkNum(x)) {
                    System.out.printf(" %d", x);
                    continue;
                }
                if (include3(x)) {
                    System.out.printf(" %d", x);
                    continue;
                }
            }
            System.out.println();
        } catch (NoSuchElementException | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static boolean checkNum(int x) {
        return x % 3 == 0;
    }

    private static boolean include3(int x) {
        if (x % 10 == 3) {
            return true;
        }
        x = x / 10;
        if (x > 0) {
            return include3(x);
        }
        return false;
    }

    private static class IllegalTestCaseException extends RuntimeException {
        IllegalTestCaseException() {
            super("Illegal condition.");
        }
    }
}
