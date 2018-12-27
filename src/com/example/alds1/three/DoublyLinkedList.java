package com.example.alds1.three;

import java.util.*;

/**
 * Not solved.
 */
public class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            Node head = new Node();
            Node tail = new Node();
            head.next = tail;
            tail.previous = head;
            while (sc.hasNext()) {
                String[] c_x = sc.nextLine().split(" ");
                if (c_x[0].equals("insert")) {
                    Node n1 = new Node(Integer.parseInt(c_x[1]));
                    Node n2 = head.next;
                    head.next = n1;
                    n2.previous = n1;
                    n1.previous = head;
                    n1.next = n2;
                }
                if (c_x[0].equals("delete")) {
                    Node n1 = head.next;
                    int t = Integer.parseInt(c_x[1]);
                    while (n1.key != -1) {
                        if (n1.key == t) {
                            break;
                        }
                        n1 = n1.next;
                    }
                    if (n1.key != -1) {
                        n1.previous.next = n1.next;
                        n1.next.previous = n1.previous;
                        n1.next = null;
                        n1.previous = null;
                    }
                }
                if (c_x[0].equals("deleteFirst") && head.next != tail) {
                    Node n1 = head.next;
                    n1.previous.next = n1.next;
                    n1.next.previous = n1.previous;
                    n1.next = null;
                    n1.previous = null;
                }
                if (c_x[0].equals("deleteLast") && head.next != tail) {
                    Node n1 = tail.previous;
                    n1.previous.next = n1.next;
                    n1.next.previous = n1.previous;
                    n1.next = null;
                    n1.previous = null;
                }
            }
            Node n1 = head.next;
            StringJoiner sj = new StringJoiner(" ");
            while(n1.key != -1) {
                sj.add(Integer.toString(n1.key));
                n1 = n1.next;
            }
            System.out.println(sj.toString());
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static class Node {
        Node() {}
        Node(int key) {
            this.key = key;
        }
        int key = -1;
        Node next;
        Node previous;
    }
}
