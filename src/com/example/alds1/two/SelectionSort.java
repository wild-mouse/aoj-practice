package com.example.alds1.two;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            int[] a = Stream.of(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            selectionSortThenPrint(a);
        } catch (NoSuchElementException | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static void selectionSortThenPrint(int[] a) {
        int swapped = 0;
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int tmp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = tmp;
                ++swapped;
            }
        }
        System.out.println(Arrays.stream(a)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
        System.out.println(swapped);
    }
}
