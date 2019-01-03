package com.example.itp1.two;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class CircleInARectangle {
    private static int MIN_XY = -100;
    private static int MAX_XY = 100;
    private static int MIN_WHR = 0;
    private static int MAX_WHR = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int[] w_h_x_y_r = Stream.of(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (w_h_x_y_r.length != 5) {
                System.out.println("Condition is invalid.");
            }
            int w = w_h_x_y_r[0];
            int h = w_h_x_y_r[1];
            int x = w_h_x_y_r[2];
            int y = w_h_x_y_r[3];
            int r = w_h_x_y_r[4];
            if (w > MAX_WHR || w < MIN_WHR || h > MAX_WHR || h < MIN_WHR
                    || r > MAX_WHR || r < MIN_WHR || x > MAX_XY || x < MIN_XY
                    || y > MAX_XY || y < MIN_XY) {
                System.out.println("Condition is invalid.");
            }
            if (0 > x - r || 0 > y - r
            || w < x + r || h < y + r) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
