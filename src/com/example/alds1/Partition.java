package com.example.alds1;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class Partition {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            int[] a = Stream.of(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int c = partition(a, 0, a.length - 1);
            StringJoiner sj = new StringJoiner(" ");
            for (int i = 0; i < a.length; i++) {
                if (i == c) {
                    sj.add("[" + a[i] + "]");
                    continue;
                }
                sj.add(Integer.toString(a[i]));
            }
            System.out.println(sj.toString());
        } catch (NoSuchElementException | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static int partition(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        for (int j = p; j < r + 1; j++) {
            if (a[j] <= x) {
                i = i + 1;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        return i;
    }
}
