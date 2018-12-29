package com.example.alds1.ten;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int q = Integer.parseInt(sc.nextLine());
            int MIN_LENGTH = 1;
            int MAX_LENGTH = 1000;
            while (sc.hasNext()) {
                String x = sc.nextLine();
                String y = sc.nextLine();
                if (x.length() < MIN_LENGTH || x.length() > MAX_LENGTH
                    || y.length() < MIN_LENGTH || y.length() > MAX_LENGTH) {
                    System.out.println("Conditions is invalid.");
                    return;
                }
                System.out.println(getLCS(x, y));
            }
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static int getLCS(String x, String y) {
        char[] xs = x.toCharArray();
        char[] ys = y.toCharArray();
        int m = x.length();
        int n = y.length();
        int[][] c = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            c[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            c[0][i] = 0;
        }

        int maxl = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (xs[i - 1] == ys[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Integer.max(c[i - 1][j], c[i][j - 1]);
                }
                maxl = Integer.max(maxl, c[i][j]);
            }
        }
        return maxl;
    }
}
