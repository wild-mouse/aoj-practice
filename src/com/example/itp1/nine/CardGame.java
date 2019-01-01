package com.example.itp1.nine;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class CardGame {
    private static int N = 1000;
    private static int S = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int ap = 0, bp = 0;
            int n = Integer.parseInt(sc.nextLine());
            if (n > N) {
                System.out.println("Condition is invalid.");
            }
            while (sc.hasNext()) {
                String[] cs = sc.nextLine().split(" ");
                if (cs[0].length() > S || cs[1].length() > S) {
                    System.out.println("Condition is invalid.");
                }
                int c = cs[0].compareTo(cs[1]);
                if (c > 0) {
                    ap += 3;
                }
                if (c == 0) {
                    ap++;
                    bp++;
                }
                if (c < 0) {
                    bp += 3;
                }
            }
            System.out.println(ap + " " + bp);
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
