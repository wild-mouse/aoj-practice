package com.example.itp1.four;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class ABProblem {
    private static double MAX = 1_000_000_000;
    private static double MIN = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            double[] a_b = Stream.of(sc.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            if (a_b.length != 2) {
                throw new IllegalTestCaseException();
            }
            double a = a_b[0];
            double b = a_b[1];
            if (a > MAX || a < MIN || b > MAX || b < MIN) {
                throw new IllegalTestCaseException();
            }
            System.out.printf("%d %d %.8f\n", (int)(a / b), (int)(a % b), a / b);
        } catch (IllegalTestCaseException
                | NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static class IllegalTestCaseException extends RuntimeException {
        IllegalTestCaseException() {
            super("Condition is invalid.");
        }
    }
}
