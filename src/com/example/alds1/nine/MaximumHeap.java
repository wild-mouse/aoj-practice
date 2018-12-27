package com.example.alds1.nine;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MaximumHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int h = Integer.parseInt(sc.nextLine());
            int[] a = new int[h + 1];
            for (int i = 1; i <= h; i++) {
                int k = sc.nextInt();
                a[i] = k;
            }
            a = buildMaxHeap(a, h);
            for (int i = 1; i <= h; i++) {
                System.out.printf(" %d", a[i]);
            }
            System.out.println();
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static int left(int i) {
        return i * 2;
    }

    private static int right(int i) {
        return i * 2 + 1;
    }

    private static int[] buildMaxHeap(int[] a, int h) {
        for (int i = h / 2; i >= 1; i--) {
            a = maxHeapify(a, i, h);
        }
        return a;
    }

    private static int[] maxHeapify(int[] a, int i, int h) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l <= h && a[l] > a[i]) {
            largest = l;
        }
        if (r <= h && a[r] > a[largest]) {
            largest = r;
        }

        if (largest != i) {
            int tmp = a[i];
            a[i] = a[largest];
            a[largest] = tmp;
            a = maxHeapify(a, largest, h);
        }
        return a;
    }
}
