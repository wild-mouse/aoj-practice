package com.example.itp1.seven;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Spreadsheet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int[] r_c = Stream.of(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int i = 0;
            int ta = 0;
            int[] tr = new int[r_c[1]];
            while (sc.hasNext()) {
                int[] es = Stream.of(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                if (es.length != r_c[1]) {
                    System.out.println("Condition is invalid.");
                    return;
                }
                es = Arrays.copyOf(es, es.length + 1);
                int tl = 0;
                for (int j = 0; j < es.length; j++) {
                    if (j == es.length - 1) {
                        es[j] = tl;
                        System.out.printf("%d\n", es[j]);
                        break;
                    }
                    System.out.printf("%d ", es[j]);
                    tl += es[j];
                    ta += es[j];
                    tr[j] += es[j];
                }
                ++i;
            }
            for (int r: tr) {
                System.out.printf("%d ", r);
            }
            System.out.printf("%d\n", ta);
            if (i != r_c[0]) {
                System.out.println("Condition is invalid.");
                return;
            }
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
