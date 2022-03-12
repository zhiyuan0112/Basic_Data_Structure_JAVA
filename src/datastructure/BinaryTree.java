package datastructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BinaryTree {
    private static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    void insert(List<Integer> list) {
        int len = list.size();
        if (len == 0) return;

        Map<Node, Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node node = new Node(list.get(0));
        this.root = node;

        int idx = 1;
        queue.offer(node);
        map.put(node, idx);

        while (!queue.isEmpty()) {
            node = queue.poll();
            idx = map.get(node);
            if (2 * idx <= len) {
                node.left = new Node(list.get(2 * idx - 1));
                queue.offer(node.left);
                map.put(node.left, 2*idx);
            }
            if (2 * idx + 1 <= len) {
                node.right = new Node(list.get(2 * idx));
                queue.offer(node.right);
                map.put(node.right, 2*idx+1);
            }

        }
    }


    void inOrder(Node data) {
        if (data != null) {
            System.out.print(data.val);
            System.out.print(", ");
            inOrder(data.left);
            inOrder(data.right);
        }
    }

    void preOrder(Node data) {
        if (data != null) {
            preOrder(data.left);
            System.out.print(data.val);
            System.out.print(", ");
            preOrder(data.right);
        }
    }

    void postOrder(Node data) {
        if (data != null) {
            postOrder(data.left);
            postOrder(data.right);
            System.out.print(data.val);
            System.out.print(", ");
        }
    }


    public static void main(String[] args) {
        System.out.println("===== list =====");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList);

        System.out.println("===== tree =====");
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(arrayList);

        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        binaryTree.postOrder(binaryTree.root);
    }
}
