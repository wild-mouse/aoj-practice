package com.example.itp1.ten;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class Distance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            double[] x1_y1_x2_y2 = Stream.of(sc.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            double x = x1_y1_x2_y2[2] - x1_y1_x2_y2[0];
            double y = x1_y1_x2_y2[3] - x1_y1_x2_y2[1];
            double z2 = x * x + y * y;
            double z = Math.pow(z2, 0.5);
            System.out.println(z);
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
