package com.example.alds1.eleven;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            int[][] m = new int[n][n];
            int i = 0;
            while (sc.hasNext()) {
                int[] u_k_vs = Stream.of(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                for (int j = 2; j < u_k_vs.length; j++) {
                    m[i][u_k_vs[j] - 1] = 1;
                }
                ++i;
            }
            if (i != n) {
                System.out.println("Conditions is invalid.");
            }
            for (int[] l: m) {
                System.out.println(IntStream.of(l).boxed()
                        .map(Object::toString)
                        .collect(Collectors.joining(" ")));
            }
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
