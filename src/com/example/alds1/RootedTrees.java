package com.example.alds1;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Not Solved.
 */
public class RootedTrees{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            Node[] ns = new Node[n];
            for (int i = 0; i < n; i++) {
                ns[i] = new Node();
            }
            while (sc.hasNext()) {
                int[] id_k_cs = Stream.of(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int id = id_k_cs[0];
                if (id_k_cs.length > 2) {
                    ns[id].left = id_k_cs[2];
                }
                for (int j = 2; j < id_k_cs.length; j++) {
                    ns[id_k_cs[j]].parent = id_k_cs[0];
                    if (j != id_k_cs.length - 1) {
                        ns[id_k_cs[j]].right = id_k_cs[j + 1];
                    }
                }
            }
            for (int i = 0; i < ns.length; i++) {
                int depth = getDepth(ns, i);
                String type = getType(ns[i]);
                String cs = getChildren(ns, i);
                System.out.printf(
                        "node %d: parent = %d, depth = %d, %s, %s\n",
                        i,
                        ns[i].parent,
                        depth,
                        type,
                        cs);
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
        int parent;
        int left;
        int right;
    }

    private static int getDepth(Node[] ns, int id) {
        int depth = 0;
        Node node = ns[id];
        while (node.parent != -1) {
            depth++;
            node = ns[node.parent];
        }
        return depth;
    }

    private static String getType(Node n) {
        if (n.parent == -1) {
            return "root";
        }
        if (n.left == -1) {
            return "leaf";
        }
        return "internal node";
    }

    private static String getChildren(Node[] ns, int id) {
        String children = "[";
        int cid = ns[id].left;
        if (cid == -1) {
            children += "]";
            return children;
        }
        Node c = ns[ns[id].left];
        children += Integer.toString(cid);
        while (c.right != -1) {
            children += ", " + c.right;
            c = ns[c.right];
        }
        children += "]";
        return children;
    }
}
