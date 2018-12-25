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
                int parent = ns[i].parent == null ? -1 : ns[i].parent;
                int depth = getDepth(ns, i);
                String type = getType(ns[i]);
                String cs = getChildren(ns, i);
                System.out.printf(
                        "node %d: parent = %d, depth = %d, %s, %s\n",
                        i,
                        parent,
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
        Node() {}
        Integer parent;
        Integer left;
        Integer right;
    }

    private static int getDepth(Node[] ns, int id) {
        int depth = 0;
        Node node = ns[id];
        while (node.parent != null) {
            depth++;
            node = ns[node.parent];
        }
        return depth;
    }

    private static String getType(Node n) {
        if (n.parent == null) {
            return "root";
        }
        if (n.left == null) {
            return "leaf";
        }
        return "internal node";
    }

    private static String getChildren(Node[] ns, int id) {
        String children = "[";
        Integer cid = ns[id].left;
        if (cid == null) {
            children += "]";
            return children;
        }
        Node c = ns[ns[id].left];
        children += cid.toString();
        while (c.right != null) {
            children += ", " + c.right.toString();
            c = ns[c.right];
        }
        children += "]";
        return children;
    }
}
