package com.example.itp1.eight;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String s = sc.nextLine();
            String p = sc.nextLine();
            String ss = s.concat(s);
            boolean hasAString = ss.contains(p);
            System.out.println(hasAString ? "Yes" : "No");
        } catch (IllegalTestCaseException
                | NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static class IllegalTestCaseException extends RuntimeException {
        IllegalTestCaseException() {
            super("Illegal condition.");
        }
    }
}
