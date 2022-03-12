public class LinkedList implements List{
    private static class Node {
        private final int val;
        private Node pre, next;

        public Node(int val){
            this.val = val;
            this.pre = null;
            this.next = null;
        }

    }

    private int len = 0;
    Node head = new Node(-1);
    Node tail = head;

    @Override
    public void pushBack(int val) {
        Node data = new Node(val);
        data.pre = tail;
        tail.next = data;
        tail = data;
        len++;
    }

    @Override
    public void popBack() {
        if (len == 0) return;
        tail = tail.pre;
        tail.next = null;
        len--;
    }

//    -1,1,2,3 (1,10)
    @Override
    public void insert(int idx, int val) {
        if (idx < 0 || idx > len) return;
        Node cur = head;
        for (int i = 0; i < idx; i++) {
            cur = cur.next;
        }
        Node data = new Node(val);
        data.next = cur.next;
        data.pre = cur;
        if (cur.next != null) cur.next.pre = data;
        cur.next = data;
        len++;
    }

    @Override
    public int size() {
        return len;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Node cur = head.next; cur != null; cur = cur.next) {
            if (cur != head.next) builder.append(", ");
            builder.append(cur.val);
        }
        return "LinkedList{" +
                "len=" + len +
                ", data=" + builder +
                '}';
    }
}
