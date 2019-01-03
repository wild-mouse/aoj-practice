package com.example.itp1.four;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (sc.hasNext()) {
                String[] a_op_b = sc.nextLine().split(" ");
                if (a_op_b.length != 3) {
                    throw new InvalidTestCaseException();
                }
                String op = a_op_b[1];
                int a = Integer.parseInt(a_op_b[0]);
                int b = Integer.parseInt(a_op_b[2]);
                if (op.equals("+")) {
                    System.out.println(a + b);
                } else if (op.equals("-")) {
                    System.out.println(a - b);
                } else if (op.equals("*")) {
                    System.out.println(a * b);
                } else if (op.equals("/")) {
                    System.out.println(a / b);
                } else if (op.equals("?")) {
                    break;
                }
            }
        } catch (InvalidTestCaseException
                | NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static class InvalidTestCaseException extends RuntimeException {
        InvalidTestCaseException() {
            super("Condition is invalid.");
        }
    }
}
