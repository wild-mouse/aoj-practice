package com.example.itp1.three;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class SwappingTwoNumbers {
    private static int MAX_XY = 10000;
    private static int MIN_XY = 0;
    private static int MAX_LENGTH = 3000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int i = 1;
            while (sc.hasNext()) {
                if (i > MAX_LENGTH) {
                    throw new InvalidTestCaseException("Condition is invalid.");
                }
                int[] x_y = Stream.of(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                if (x_y.length != 2) {
                    throw new InvalidTestCaseException("Condition is invalid.");
                }
                int x = x_y[0];
                int y = x_y[1];
                if (x > MAX_XY || x < MIN_XY
                    || y > MAX_XY || y < MIN_XY) {
                    throw new InvalidTestCaseException("Condition is invalid.");
                }
                if (x == 0 && y == 0) {
                    break;
                }
                System.out.printf("%d %d\n", Integer.min(x, y), Integer.max(x, y));
                i++;
            }
        } catch (InvalidTestCaseException
                | NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }
}

class InvalidTestCaseException extends RuntimeException {
    InvalidTestCaseException(String message) {
        super(message);
    }
}
