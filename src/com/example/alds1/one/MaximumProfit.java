package com.example.alds1.one;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MaximumProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            int[] rs = new int[n];
            int i = 0;
            while (sc.hasNext()) {
                rs[i++] = Integer.parseInt(sc.nextLine());
            }
            int rij = -1_000_000_000;
            int min = 1_000_000_000;
            for (i = 1; i < n; i++) {
                if (min > rs[i - 1]) {
                    min = rs[i - 1];
                }
                if (rij < rs[i] - min) {
                    rij = rs[i] - min;
                }
            }
            System.out.println(rij);
        } catch (NoSuchElementException | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
