package com.example.alds1.eleven;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Stream;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            int[][] m = new int[n][n];
            while (sc.hasNext()) {
                int[] u_k_vs = Stream.of(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int i = 2; i < u_k_vs.length; i++) {
                    m[u_k_vs[0] - 1][u_k_vs[i] - 1] = 1;
                }
            }
            bfs(n, 0, m);
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static void bfs(int n, int start, int[][] m) {
        Queue<Integer> q = new ArrayBlockingQueue<>(n);
        q.add(start);
        int[] d = new int[n];
        Arrays.fill(d, -1);
        d[start] = 0;
        while (!q.isEmpty()) {
            int u = q.remove();
            for (int i = 0; i < n; i++) {
                if (m[u][i] == 0) {
                    continue;
                }
                if (d[i] != -1) {
                    continue;
                }
                d[i] = d[u] + 1;
                q.add(i);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " " + d[i]);
        }
    }
}
