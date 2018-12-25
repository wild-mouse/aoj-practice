package com.example.alds1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            String[] cs = new String[n];
            int i = 0;
            while (sc.hasNext()) {
                cs[i++] = sc.nextLine();
            }
            String[] csm = cs.clone();
            mergeSort(csm, 0, cs.length);
            quickSort(cs, 0, cs.length - 1);
            boolean isStable = true;
            for (i = 0; i < cs.length; i++) {
                if (cs[i] != csm[i]) {
                    isStable = false;
                }
            }
            if (isStable) {
                System.out.println("Stable");
            } else {
                System.out.println("Not stable");
            }
            for (int j = 0; j < cs.length; j++) {
                System.out.println(cs[j]);
            }
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static int partition(String[] cs, int p, int r) {
        int x = Integer.parseInt(cs[r].split(" ")[1]);
        int i = p - 1;
        for (int j = p; j <= r; j++) {
            if (x >= Integer.parseInt(cs[j].split(" ")[1])) {
                i = i + 1;
                String tmp = cs[i];
                cs[i] = cs[j];
                cs[j] = tmp;
            }
        }
        return i;
    }

    private static void quickSort(String[] cs, int p, int r) {
        if (p < r) {
            int q = partition(cs, p, r);
            quickSort(cs, p, q - 1);
            quickSort(cs, q + 1, r);
        }
    }

    private static void mergeSort(String[] cs, int left, int right) {
        if ((left + 1) < right) {
            int mid = (left + right) / 2;
            mergeSort(cs, left, mid);
            mergeSort(cs, mid, right);
            merge(cs, left, mid, right);
        }
    }

    private static void merge(String[] cs, int left, int mid, int right) {
        int n1 = mid - left;
        int n2 = right - mid;
        String[] ll = new String[n1];
        String[] rl = new String[n2];
        for (int i = 0; i < n1; i++) {
            ll[i] = cs[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rl[i] = cs[mid + i];
        }
        int i = 0, j = 0;
        for (int k = left; k < right; k++) {
            if (i < ll.length
                    && (j >= rl.length ||
                    Integer.parseInt(ll[i].split(" ")[1])
                            <= Integer.parseInt(rl[j].split(" ")[1]))) {
                cs[k] = ll[i];
                i = i + 1;
            } else {
                cs[k] = rl[j];
                j = j + 1;
            }
        }
    }
}
