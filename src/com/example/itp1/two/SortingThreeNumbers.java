package com.example.itp1.two;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String sorted = Stream.of(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .boxed()
                    .map(Object::toString)
                    .collect(Collectors.joining(" "));
            System.out.println(sorted);
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }
}
