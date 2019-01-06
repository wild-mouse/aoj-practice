package com.example.alds1.twelve;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MinimumSpanningTree {
    private static int INF = 1 << 21;
    private static int WHITE = 0;
    private static int GRAY = 1;
    private static int BLACK = 2;
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner("5\n" +
                " -1 2 3 1 -1\n" +
                " 2 -1 -1 4 -1\n" +
                " 3 -1 -1 1 1\n" +
                " 1 4 1 -1 3\n" +
                " -1 -1 1 3 -1\n");
        try {
            int n = Integer.parseInt(sc.nextLine());
            int[][] m = new int[n][n];
            while (sc.hasNext()) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        int a = sc.nextInt();
                        m[i][j] = a == -1 ? INF : a;
                    }
                }
            }
            int c = prim(n, m);
            System.out.println(c);
        } catch (NoSuchElementException | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static int prim(int n, int[][] m) {
        int u, minv;
        int[] d = new int[n];
        int[] p = new int[n];
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            d[i] = INF;
            p[i] = -1;
            color[i] = WHITE;
        }
        d[0] = 0;
        while (true) {
            minv = INF;
            u = -1;
            for (int i = 0; i < n; i++) {
                if (minv > d[i] && color[i] != BLACK) {
                    u = i;
                    minv = d[i];
                }
            }
            if (u == -1) {
                break;
            }
            color[u] = BLACK;
            for (int v = 0; v < n; v++) {
                if (color[v] != BLACK && m[u][v] != INF) {
                    if (d[v] > m[u][v]) {
                        d[v] = m[u][v];
                        p[v] = u;
                        color[v] = GRAY;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] != -1) {
                sum += m[i][p[i]];
            }
        }
        return sum;
    }
}
