package com.example.alds1;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class TreeWalk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            Node[] ns = new Node[n];
            for (int i = 0; i < n; i++) {
                ns[i] = new Node();
            }
            while (sc.hasNext()) {
                int[] id_l_r = Stream.of(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                ns[id_l_r[0]].left = id_l_r[1];
                ns[id_l_r[0]].right = id_l_r[2];
                if (id_l_r[1] != -1) {
                    ns[id_l_r[1]].parent = id_l_r[0];
                }
                if (id_l_r[2] != -1) {
                    ns[id_l_r[2]].parent = id_l_r[0];
                }
            }
            int r = 0;
            for (int i = 0; i < n; i++) {
                if (ns[i].parent == -1) {
                    r = i;
                }
            }
            System.out.println("Preorder");
            printPreorder(ns, r);
            System.out.println();
            System.out.println("Inorder");
            printInorder(ns, r);
            System.out.println();
            System.out.println("Postorder");
            printPostorder(ns, r);
            System.out.println();
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static class Node {
        Node() {}
        int parent = -1, left = -1, right = -1;
    }

    private static void printPreorder(Node[] ns, int r) {
        System.out.printf(" %d", r);
        if (ns[r].left != -1) {
            printPreorder(ns, ns[r].left);
        }
        if (ns[r].right != -1) {
            printPreorder(ns, ns[r].right);
        }
    }

    private static void printInorder(Node[] ns, int r) {
        if (ns[r].left != -1) {
            printInorder(ns, ns[r].left);
        }
        System.out.printf(" %d", r);
        if (ns[r].right != -1) {
            printInorder(ns, ns[r].right);
        }
    }

    private static void printPostorder(Node[] ns, int r) {
        if (ns[r].left != -1) {
            printPostorder(ns, ns[r].left);
        }
        if (ns[r].right != -1) {
            printPostorder(ns, ns[r].right);
        }
        System.out.printf(" %d", r);
    }
}
