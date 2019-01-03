package com.example.itp1.three;

import java.util.stream.IntStream;

public class PrintManyHelloWorld {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 1000)
                .forEach(i -> {
                    System.out.println("Hello World");
                });
    }
}
