package com.example.alds1.ten;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            int MIN = 0, MAX = 44;
            if (n < MIN || n > MAX) {
                System.out.println("Condition is invalid.");
                return;
            }
            int[] fs = new int[MAX + 1];
            System.out.println(fibonacci(n, fs));
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static int fibonacci(int n, int[] fs) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (fs[n] != 0) {
            return fs[n];
        }
        fs[n] = fibonacci(n - 1, fs) + fibonacci(n - 2, fs);
        return fs[n];
    }
}
