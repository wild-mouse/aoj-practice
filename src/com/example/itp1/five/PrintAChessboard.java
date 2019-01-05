package com.example.itp1.five;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class PrintAChessboard {
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
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        if ((i + j) % 2 == 0) {
                            System.out.print("#");
                        } else {
                            System.out.print(".");
                        }
                    }
                    System.out.println();
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
