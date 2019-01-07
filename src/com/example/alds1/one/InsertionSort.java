package com.example.alds1.one;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            if (n > 100 || n < 1) {
                throw new IllegalTestCaseException();
            }
            int[] a = Stream.of(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int targetIndex = 0; targetIndex < a.length; targetIndex++) {
                a = oneTimeInsertionSort(targetIndex, a);
                System.out.println(Arrays.stream(a)
                        .boxed()
                        .map(Object::toString)
                        .collect(Collectors.joining(" ")));
            }
        } catch (IllegalTestCaseException
                | NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static int[] oneTimeInsertionSort(int targetIndex, int[] a) {
        int targetValue = a[targetIndex];
        int comparingIndex = targetIndex - 1;
        while (comparingIndex >= 0 && a[comparingIndex] > targetValue) {
            a[comparingIndex + 1] = a[comparingIndex];
            --comparingIndex;
        }
        a[comparingIndex + 1] = targetValue;
        return a;
    }

    private static class IllegalTestCaseException extends RuntimeException {
        IllegalTestCaseException() {
            super("Illegal condition.");
        }
    }
}
