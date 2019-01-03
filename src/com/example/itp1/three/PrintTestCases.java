package com.example.itp1.three;

        import java.util.NoSuchElementException;
        import java.util.Scanner;

public class PrintTestCases {
    private static int MAX = 10000;
    private static int MIN = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int i = 1;
            while (sc.hasNext()) {
                int x = Integer.parseInt(sc.nextLine());
                if (x == 0) {
                    break;
                }
                if (x > MAX || x < MIN || i > MAX) {
                    System.out.println("Condition is invalid.");
                    return;
                }
                System.out.printf("Case %d: %d\n", i++, x);
            }
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
