package com.example.itp1.two;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class SmallLargeEqual {
    private static int MIN = -1000;
    private static int MAX = 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int[] a_b = Stream.of(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (a_b.length != 2
                    || a_b[0] > MAX || a_b[0] < MIN
                    || a_b[1] > MAX || a_b[1] < MIN) {
                System.out.println("Condition is invalid.");
                return;
            }
            int a = a_b[0];
            int b = a_b[1];
            if (a == b) {
                System.out.println("a == b");
            } else if (a > b) {
                System.out.println("a > b");
            } else {
                System.out.println("a < b");
            }
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
