package com.example.itp1.seven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HowManyWays {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s;
            while ((s = br.readLine()) != null) {
                int[] n_x = Stream.of(s.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                if (n_x.length != 2) {
                    throw new IllegalTestCaseException();
                }
                int n = n_x[0];
                int x = n_x[1];
                if (n == 0 && x == 0) {
                    break;
                }
                System.out.println(findCombinations(n, x));
            }
        } catch (IllegalTestCaseException
                | IOException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static int findCombinations(int n, int x) {
        int count = 0;
        boolean[][][] found = new boolean[n][n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                if (i + j > x) {
                    continue;
                }
                for (int k = 3; k <= n; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    if (i + j + k == x) {
                        int[] s = IntStream.of(i, j, k).sorted().toArray();
                        if (found[s[0] - 1][s[1] - 1][s[2] - 1]) {
                            continue;
                        }
                        ++count;
                        found[s[0] - 1][s[1] - 1][s[2] - 1] = true;
                    }
                }
            }
        }
        return count;
    }

    private static class IllegalTestCaseException extends RuntimeException {
        IllegalTestCaseException() {
            super("Illegal condition.");
        }
    }
}
