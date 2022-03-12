package datastructure;

public class Graph {
    private class Node {
        int val;
        Node father;

        Node(int val) {
            this.val = val;
            this.father = null;
        }
    }

    public static int MIN_CAPACITY = 10;
    public static int EXPAND_RATIO = 2;

    private int capacity = MIN_CAPACITY;
    private int size = 0;
    private  Node[] vertices;

    private void resizeIfNeed() {
        if(capacity == MIN_CAPACITY || size > capacity/EXPAND_RATIO && size < capacity)
            return;
        if (size == capacity) {
            capacity *= EXPAND_RATIO;
        } else if (size == capacity / EXPAND_RATIO) {
            capacity /= EXPAND_RATIO;
        }
        Node[] new_data = new Node[capacity];
        System.arraycopy(vertices, 0, new_data, 0, size);
        vertices = new_data;
    }

    public void add(int val) {
        size++;
        resizeIfNeed();
        vertices[size-1] = new Node(val);
    }

    public static void main(String[] args) {

    }
}
