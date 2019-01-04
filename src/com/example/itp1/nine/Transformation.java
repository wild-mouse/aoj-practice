package com.example.itp1.nine;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Transformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String s = sc.nextLine();
            int q = Integer.parseInt(sc.nextLine());
            if (s.length() > 1000 || s.length() < 1
                    || q > 100 || q < 1) {
                throw new IllegalTestCaseException();
            }
            while (sc.hasNext()) {
                String[] c_a_b_p = sc.nextLine().split(" ");
                String c = c_a_b_p[0];
                int a = Integer.parseInt(c_a_b_p[1]);
                int b = Integer.parseInt(c_a_b_p[2]);
                if (c.equals("replace")) {
                    s = replace(s, a, b, c_a_b_p[3]);
                } else if (c.equals("reverse")) {
                    s = reverse(s, a, b);
                } else if (c.equals("print")) {
                    System.out.println(s.substring(a, b + 1));
                } else {
                    throw new IllegalTestCaseException();
                }
            }
        } catch (IllegalTestCaseException
                | NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static String replace(String s, int a, int b, String ns) {
        String f = "", m = "", l = "";
        if (a != 0) {
            f = s.substring(0, a);
        }
        m = ns;
        if (b != s.length()) {
            l = s.substring(b + 1);
        }
        return f.concat(m).concat(l);
    }

    private static String reverse(String s, int a, int b) {
        char[] cs = s.toCharArray();
        char[] ncs = cs.clone();
        for (int i = 0; i <= b - a; i++) {
            ncs[a + i] = cs[b - i];
        }
        return String.valueOf(ncs);
    }

    private static class IllegalTestCaseException extends RuntimeException {
        IllegalTestCaseException() {
            super("Illegal condition.");
        }
    }
}
