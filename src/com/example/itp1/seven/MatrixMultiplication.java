package com.example.itp1.seven;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int[] n_m_l = Stream.of(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            long[][] a = new long[n_m_l[0]][n_m_l[1]];
            long[][] b = new long[n_m_l[1]][n_m_l[2]];
            for (int i = 0; i < n_m_l[0]; i++) {
                long[] al = Stream.of(sc.nextLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
                if (al.length != n_m_l[1]) {
                    System.out.println("Condition is invalid,");
                }
                a[i] = al;
            }
            for (int i = 0; i < n_m_l[1]; i++) {
                long[] bl = Stream.of(sc.nextLine().split(" "))
                        .mapToLong(Long::parseLong)
                        .toArray();
                if (bl.length != n_m_l[2]) {
                    System.out.println("Condition is invalid,");
                }
                b[i] = bl;
            }
            long[][] c = new long[n_m_l[0]][n_m_l[2]];
            for (int i = 0; i < n_m_l[0]; i++) {
                for (int j = 0; j < n_m_l[2]; j++) {
                    for (int k = 0; k < n_m_l[1]; k++) {
                        c[i][j] += a[i][k] * b[k][j];
                    }
                }
                System.out.println(LongStream.of(c[i])
                        .boxed()
                        .map(Object::toString)
                        .collect(Collectors.joining(" ")));
            }
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
