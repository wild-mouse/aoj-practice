package com.example.itp1.two;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Range {
    private static int MIN = -100;
    private static int MAX = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int[] a_b_c = Stream.of(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (a_b_c.length != 3) {
                System.out.println("Condition is invalid");
            }
            int a = a_b_c[0];
            int b = a_b_c[1];
            int c = a_b_c[2];
            if (a > MAX || a < MIN
            || b > MAX || b < MIN
            || c > MAX || c < MIN) {
                System.out.println("Condition is invalid");
            }
            if (a < b && b < c) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
