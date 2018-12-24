package com.example.itp1;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Rectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int[] a_b = Stream.of(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .toArray();
            if (a_b.length != 2) {
                System.out.println("Numbers of args not match.");
            }
            int a = a_b[0];
            int b = a_b[1];
            System.out.printf("%d %d\n", a * b, (a + b) * 2);
        } catch (NoSuchElementException | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
