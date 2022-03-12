package datastructure;

public class LinkedList<E> implements List<E> {
    private static class Node<E> {
        private E val;
        private Node<E> pre;
        private Node<E> next;

        public Node(E val) {
            this.val = val;
            this.pre = null;
            this.next = null;
        }
    }

    private int size;
    private Node<E> head;
    private Node<E> tail;

    public LinkedList() {
        this.size = 0;
        head = new Node<>(null);
        tail = head;
    }

    @Override
    public void add(E val) {
        size++;
        Node<E> data = new Node<>(val);
        tail.next = data;
        data.pre = tail;
        tail = tail.next;
    }

    @Override
    public void add(int idx, E e) {
        if (idx < 0 || idx > size)
            throw new IndexOutOfBoundsException(idx);
        size++;
        Node<E> cur = head;
        for (int i = 0; i < idx; i++) {
            cur = cur.next;
        }
        Node<E> new_data = new Node<>(e);
        new_data.pre = cur;
        new_data.next = cur.next;
        if (cur.next != null) cur.next.pre = new_data;
        cur.next = new_data;
    }

    @Override
    public void remove() {
        if (size == 0) return;
        size--;
        tail = tail.pre;
        tail.next = null;
    }

    @Override
    public void remove(int idx) {

    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int idx) {
        if (idx < 0 && idx >= size)
            throw new IndexOutOfBoundsException(idx);
        Node<E> node = head;
        int i = 0;
        while (i < idx) {
            node = node.next;
            i++;
        }
        return node.val;
    }

    @Override
    public E set(int idx) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Node<E> cur = head.next; cur != null; cur = cur.next) {
            if (cur != head.next) builder.append(", ");
            builder.append(cur.val);
        }
        return "LinkedList{" +
                "len=" + size +
                ", data=" + builder +
                '}';
    }
}
