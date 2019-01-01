package com.example.itp1.nine;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class FindingAWord {
    private static int W = 10;
    private static int T = 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String w = sc.nextLine();
            if (w.length() > W) {
                System.out.println("Condition is invalid.");
                return;
            }
            int c = 0;
            while (sc.hasNext()) {
                String s = sc.next().toLowerCase();
                if (s.equals("END_OF_TEXT")) {
                    break;
                }
                if (s.equals(w)) {
                    c++;
                }
            }
            System.out.println(c);
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }
}
