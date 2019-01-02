package com.example.itp1.four;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MinMaxSum {
    private static int MIN = -1000000;
    private static int MAX = 1000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            int min = MAX;
            int max = MIN;
            double total = 0;
            while (sc.hasNext()) {
                int a = sc.nextInt();
                max = Integer.max(a, max);
                min = Integer.min(a, min);
                total += a;
            }
            System.out.printf("%d %d %.0f\n", min, max, total);
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
