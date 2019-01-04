package com.example.itp1.four;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Circle {
    private static double MAX = 10_000;
    private static double MIN = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            double  r = Double.parseDouble(sc.nextLine());
            if (r > MAX || r < MIN) {
                throw new IllegalTestCaseException();
            }
            double a = Math.PI * r * r;
            double c = 2 * Math.PI * r;
            System.out.printf("%.8f %.8f\n", a, c);
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
