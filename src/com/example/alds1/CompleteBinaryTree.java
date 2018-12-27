package com.example.alds1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CompleteBinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int k = sc.nextInt();
                a[i] = k;
            }
            for (int i = 1; i <= n; i++) {
                System.out.printf("node %d: ", i);
                System.out.printf("key = %d, ", a[i]);
                if (parent(i) >= 1) {
                    System.out.printf("parent key = %d, ", a[parent(i)]);
                }
                if (left(i) <= n) {
                    System.out.printf("left key = %d, ", a[left(i)]);
                }
                if (right(i) <= n) {
                    System.out.printf("right key = %d, ", a[right(i)]);
                }
                System.out.println();
            }
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static int parent(int i) {
        return i / 2;
    }

    private static int left(int i) {
        return i * 2;
    }

    private static int right(int i) {
        return i * 2 + 1;
    }
}
