package com.example.alds1.one;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       try {
            int c = 0;
            int n = Integer.parseInt(sc.nextLine());
            if (n > 10000 || n < 1) {
                throw new IllegalTestCaseException();
            }
            while (sc.hasNext()) {
                int x = Integer.parseInt(sc.nextLine());
                if (x > 100_000_000 || x < 2) {
                    throw new IllegalTestCaseException();
                }
                if (isPrimeNumber(x)) {
                    ++c;
                }
            }
            System.out.println(c);
        } catch (NoSuchElementException | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static boolean isPrimeNumber(int x) {
        int compositeNumber = (int)Math.pow(x, 0.5);
        for (int i = 2; i <= compositeNumber; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static class IllegalTestCaseException extends RuntimeException {
        IllegalTestCaseException() {
            super("Illegal condition.");
        }
    }
}
