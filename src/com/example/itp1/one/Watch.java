package com.example.itp1.one;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Watch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int s = Integer.parseInt(sc.nextLine());
            if (s >= 86400 || s < 0) {
                System.out.println("Input is incorrect");
                return;
            }
            int h = s / (60 * 60);
            int r = s % (60 * 60);
            int m = r / 60;
            r = s % 60;
            System.out.printf("%d:%d:%d\n", h, m, r);
        } catch (NoSuchElementException | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
