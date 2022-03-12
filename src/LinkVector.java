public class LinkVector {
    public static class Node {
        private int val;
        private Node next;
        private Node pre;
        public Node(int val){
            this.val = val;
            this.next = null;
            this.pre = null;
        }
    }

    private int len;
    private Node head = new Node(-1);
    private Node tail = head;

    public void push_back(int val){
        Node new_data = new Node(val);
        new_data.pre = tail;
        tail.next = new_data;
        tail = new_data;
        len++;
    }
    public void pop_back(){
        if (len == 0) {
            return;
        }
        tail = tail.pre;
        len--;
    }
    public void insert(int idx, int val){
        Node cur = head;
        for (int i = 0; i < idx; i++) {
            cur = cur.next;
        }
        Node new_data = new Node(val);
        new_data.pre = cur;
        new_data.next = cur.next;
        cur.next.pre = new_data;
        cur.next = new_data;
        len++;
    }
    public int size(){
        return this.len;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for (Node cur = head.next; cur!=null; cur=cur.next) {
            if(cur != head.next) data.append(',');
            data.append(cur.val);
        }
        return "LinkVector{" +
                "len=" + len +
                ", data=" + data +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
