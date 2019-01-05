package com.example.itp1.ten;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class DistanceII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            if (n > 100 || n < 1) {
                throw new IllegalTestCaseException();
            }
            double[] xs = Stream.of(sc.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            double[] ys = Stream.of(sc.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            if (n != xs.length || n != ys.length) {
                throw new IllegalTestCaseException();
            }
            double d1 = minkowskiDistance(n, xs, ys, 1);
            double d2 = minkowskiDistance(n, xs, ys, 2);
            double d3 = minkowskiDistance(n, xs, ys, 3);
            double di = minkowskiDistance(n, xs, ys, -1);
            System.out.printf("%.8f\n%.8f\n%.8f\n%.8f\n", d1, d2, d3, di);
        } catch (IllegalTestCaseException
                | NumberFormatException
                | NoSuchElementException e) {
            System.out.println(e);
        }
    }

    /**
     * @param p
     *   if p is -1, it means p is infinity.
     */
    private static double minkowskiDistance(int n, double[] xs, double[] ys, double p) {
        if (p == -1) {
            double max = -1;
            for (int i = 0; i < n; i++) {
                max = Double.max(Math.abs(xs[i] - ys[i]), max);
            }
            return max;
        }
        double summation = 0;
        for (int i = 0; i < n; i++) {
            summation += Math.pow(Math.abs(xs[i] - ys[i]), p);
        }
        summation = Math.pow(summation, 1 / p);
        return summation;
    }

    private static class IllegalTestCaseException extends RuntimeException {
        IllegalTestCaseException() {
            super("Illegal condition.");
        }
    }
}
