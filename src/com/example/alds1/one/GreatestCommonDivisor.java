package com.example.alds1.one;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int[] x_y = Stream.of(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int x = x_y[0];
            int y = x_y[1];
            int gcd = calculateGCD(x, y);
            System.out.println(gcd);
        } catch (NoSuchElementException | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static int calculateGCD(int x, int y) {
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        while (y > 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }
}
