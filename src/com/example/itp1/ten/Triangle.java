package com.example.itp1.ten;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            double[] a_b_C = Stream.of(sc.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            if (a_b_C.length != 3) {
                throw new IllegalTestCaseException();
            }
            double a = a_b_C[0];
            double b = a_b_C[1];
            double C = a_b_C[2];
            double S = a * b / 2 * Math.sin(Math.PI * C / 180);
            double c = Math.pow((a * a + b * b - 2 * a * b * Math.cos(Math.PI * C / 180)), 0.5);
            double l = a + b + c;
            double h = S / (a / 2);
            System.out.printf("%.8f\n", S);
            System.out.printf("%.8f\n", l);
            System.out.printf("%.8f\n", h);
        } catch (NoSuchElementException | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static class IllegalTestCaseException extends RuntimeException {
        IllegalTestCaseException() {
            super("Illegal condition.");
        }
    }
}
