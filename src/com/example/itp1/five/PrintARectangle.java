package com.example.itp1.five;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class PrintARectangle {
    private static int MAX = 300;
    private static int MIN = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (sc.hasNext()) {
                int[] h_w = Stream.of(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                if (h_w.length != 2) {
                    throw new IllegalTestCaseException();
                }
                int h = h_w[0];
                int w = h_w[1];
                if (h == 0 && w == 0) {
                    break;
                }
                if (h > MAX || h < MIN || w > MAX || w < MIN) {
                    throw new IllegalTestCaseException();
                }
                String r = "";
                for (int i = 0; i < w; i++) {
                    r += "#";
                }
                for (int i = 0; i < h; i++) {
                    System.out.println(r);
                }
                System.out.println();
            }
        } catch (IllegalTestCaseException
                | NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static class IllegalTestCaseException extends RuntimeException {
        IllegalTestCaseException() {
            super("Illegal condition.");
        }
    }
}
