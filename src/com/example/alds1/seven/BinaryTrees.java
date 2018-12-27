package com.example.alds1.seven;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

public class BinaryTrees {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            Node[] ns = new Node[n];
            for (int i = 0; i < n; i++) {
                ns[i] = new Node();
            }
            while (sc.hasNext()) {
                int[] id_left_right = Stream.of(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                ns[id_left_right[0]].left = id_left_right[1];
                ns[id_left_right[0]].right = id_left_right[2];
                if (id_left_right[1] != -1) {
                    ns[id_left_right[1]].parent = id_left_right[0];
                }
                if (id_left_right[2] != -1) {
                    ns[id_left_right[2]].parent = id_left_right[0];
                }
            }
            int r = -1;
            for (int i = 0; i < ns.length; i++) {
                if (ns[i].parent == -1) {
                    r = i;
                }
            }
            int[] ds = new int[n];
            setDepth(ns, ds, r, 0);
            int[] hs = new int[n];
            setHeights(ns, hs, r);
            for (int i = 0; i < ns.length; i++) {
                System.out.printf("node %d: parent = %d, sibling = %d, degree = %d, depth = %d, height = %d, %s\n",
                        i,
                        ns[i].parent,
                        getSibling(ns, i),
                        getDegrees(ns, i),
                        ds[i],
                        hs[i],
                        getType(ns[i]));
            }
        } catch (NoSuchElementException
                | NumberFormatException e) {
            System.out.println(e);
        }
    }

    private static class Node {
        Node() {
            this.parent = -1;
            this.left = -1;
            this.right = -1;
        }
        int parent, left, right;
    }

    private static int getSibling(Node[] ns, int id) {
        if (ns[id].parent == -1) {
            return -1;
        }
        Node p = ns[ns[id].parent];
        if (p.left != -1 && p.left != id) {
            return p.left;
        }
        if (p.right != -1 && p.right != id) {
            return p.right;
        }
        return -1;
    }

    private static int getDegrees(Node[] ns, int id) {
        int d = 0;
        if (ns[id].left != -1) {
            d++;
        }
        if (ns[id].right != -1) {
            d++;
        }
        return d;
    }

    private static void setDepth(Node[] ns, int[] ds, int r, int d) {
        ds[r] = d;
        if (ns[r].left != -1) {
            setDepth(ns, ds, ns[r].left, d + 1);
        }
        if (ns[r].right != -1) {
            setDepth(ns, ds, ns[r].right, d + 1);
        }
    }

    private static int setHeights(Node[] ns, int[] hs, int id) {
        int h1 = 0, h2 = 0;
        if (ns[id].left != -1) {
            h1 = setHeights(ns, hs, ns[id].left) + 1;
        }
        if (ns[id].right != -1) {
            h2 = setHeights(ns, hs, ns[id].right) + 1;
        }
        hs[id] = Integer.max(h1, h2);
        return hs[id];
    }

    private static String getType(Node n) {
        if (n.parent == -1) {
            return "root";
        }
        if (n.left == -1 && n.right == -1) {
            return "leaf";
        }
        return "internal node";
    }
}
