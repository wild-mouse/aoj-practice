package com.example.alds1.eleven;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Stream;

public class DepthFirstSearch {
    private static int WHITE = 0;
    private static int GRAY = 1;
    private static int BLACK = 2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            int[][] m = new int[n][n];
            while (sc.hasNext()) {
                int[] u_k_vs = Stream.of(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int u = u_k_vs[0];
                for (int i = 2; i < u_k_vs.length; i++) {
                    m[u - 1][u_k_vs[i] - 1] = 1;
                }
            }
            dfs(n, m);
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static void dfs(int n, int[][] m) {
        int[] colors = new int[n];
        Arrays.fill(colors, WHITE);
        int[] nt = new int[n];
        int[] d = new int[n];
        int[] f = new int[n];
        int tt = 0;
        for (int i = 0; i < n; i++) {
            if (colors[i] == WHITE) {
                tt = visitByDFS(i, n, tt, nt, colors, d, f, m);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%d %d %d\n", i + 1, d[i], f[i]);
        }
    }

    private static int visitByDFS(
            int r,
            int n,
            int tt,
            int[] nt,
            int[] colors,
            int[] d,
            int[] f,
            int[][] m
    ) {
        for (int i = 0; i < n; i++) {
            nt[i] = 0;
        }
        Stack<Integer> s = new Stack<>();
        s.push(r);
        colors[r] = GRAY;
        d[r] = ++tt;

        while (!s.empty()) {
            int u = s.peek();
            int v = findNext(n, u, nt, m);
            if (v != -1) {
                if (colors[v] == WHITE) {
                    colors[v] = GRAY;
                    d[v] = ++tt;
                    s.push(v);
                }
            } else {
                s.pop();
                colors[u] = BLACK;
                f[u] = ++tt;
            }
        }
        return tt;
    }

    private static int findNext(int n, int u, int[] nt, int[][] m) {
        for (int i = nt[u]; i < n; i++) {
            nt[u] = i + 1;
            if (m[u][i] == 1) {
                return i;
            }
        }
        return -1;
    }
}
