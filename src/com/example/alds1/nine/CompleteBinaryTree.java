package com.example.alds1.nine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class CompleteBinaryTree {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            int[] tmp = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (n != tmp.length) {
                System.out.println("Heap size not match.");
                return;
            }
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = tmp[i - 1];
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
        } catch (IOException
                | NoSuchElementException
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
