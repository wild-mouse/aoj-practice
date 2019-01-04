package com.example.itp1.ten;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class StandardDeviation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (sc.hasNext()) {
                int n = Integer.parseInt(sc.nextLine());
                if (n == 0) {
                    break;
                }
                double[] ss = Stream.of(sc.nextLine().split(" "))
                        .mapToDouble(Double::parseDouble)
                        .toArray();
                if (n != ss.length) {
                    throw new IllegalTestCaseException();
                }
                double summation = summationForSD(ss);
                double alpha = Math.pow(summation / n, 0.5);
                System.out.printf("%.8f\n", alpha);
            }
        } catch (IllegalTestCaseException
                | NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static double meanOf(double[] ss) {
        double sum = 0;
        for (double s: ss) {
            sum += s;
        }
        return sum / ss.length;
    }

    private static double summationForSD(double[] ss) {
        double summation = 0;
        double m = meanOf(ss);
        for (double s: ss) {
            summation += Math.pow((s - m), 2);
        }
        return summation;
    }

    private static class IllegalTestCaseException extends RuntimeException {
        IllegalTestCaseException() {
            super("Illegal condition.");
        }
    }
}
