package com.example.alds1.two;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            int[] a = Stream.of(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (n > 100 || n < 1 || n != a.length) {
                throw new IllegalTestCaseException();
            }
            bubbleSortThenPrint(a);
        } catch (IllegalTestCaseException
                | NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static void bubbleSortThenPrint(int[] a) {
        boolean hasAdjacent = true;
        int count = 0;
        while (hasAdjacent) {
            hasAdjacent = false;
            for (int i = a.length - 1; i > 0; i--) {
                if (a[i] < a[i - 1]) {
                    int tmp = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = tmp;
                    hasAdjacent = true;
                    ++count;
                }
            }
        }
        System.out.println(Arrays.stream(a)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
        System.out.println(count);
    }

    private static class IllegalTestCaseException extends RuntimeException {
        IllegalTestCaseException() {
            super("Illegal condition.");
        }
    }
}
