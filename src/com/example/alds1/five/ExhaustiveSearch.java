package com.example.alds1.five;

import java.util.HashMap;
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
            HashMap<Integer, HashMap<Integer, Boolean>> dp = new HashMap<>();
            for (int target : ms) {
                if (hasCombination(target, a, 0, dp)) {
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

    private static boolean hasCombination(
            int target,
            int[] elements,
            int i,
            HashMap<Integer, HashMap<Integer, Boolean>> dp
    ) {
        HashMap<Integer, Boolean> m = dp.get(i);
        Boolean a;
        if (m != null && (a = m.get(target)) != null) {
            return a;
        }

        if (m == null) {
            m = new HashMap<>();
            dp.put(i, m);
        }
        if (target == 0) {
            m.put(target, Boolean.TRUE);
        } else if (elements.length <= i) {
            m.put(target, Boolean.FALSE);
        } else if (hasCombination(target, elements, i + 1, dp)) {
            m.put(target, Boolean.TRUE);
        } else if (hasCombination(target - elements[i], elements, i + 1, dp)) {
            m.put(target, Boolean.TRUE);
        } else {
            m.put(target, Boolean.FALSE);
        }
        dp.put(i, m);

        return dp.get(i).get(target);
    }
}
