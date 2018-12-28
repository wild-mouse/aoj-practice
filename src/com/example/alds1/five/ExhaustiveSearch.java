package com.example.alds1.five;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class ExhaustiveSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            int[] a = Stream.of(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int q = Integer.parseInt(sc.nextLine());
            int[] ms = Stream.of(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (n != a.length || q != ms.length) {
                System.out.println("Conditions is invalid.");
                return;
            }
            for (int m : ms) {
                if (hasCombination(m, a, 0,0)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static boolean hasCombination(int target, int[] elements, int i, int s) {
        if (target == s) {
            return true;
        }
        if (elements.length <= i) {
            return false;
        }
        return hasCombination(target, elements, i + 1, s + elements[i])
                || hasCombination(target, elements, i + 1, s);
    }
}
