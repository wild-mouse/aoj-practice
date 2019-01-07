package com.example.joi.prelim;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Pencils {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int[] n_a_b_c_d = Stream.of(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int n = n_a_b_c_d[0];
            float a = n_a_b_c_d[1];
            int b = n_a_b_c_d[2];
            float c = n_a_b_c_d[3];
            int d = n_a_b_c_d[4];
            int pab = (int)Math.ceil(n / a) * b;
            int pcd = (int)Math.ceil(n / c) * d;
            System.out.println(Integer.min(pab, pcd));
        } catch (NoSuchElementException | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
