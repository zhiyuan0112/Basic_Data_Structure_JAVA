public class Main {
    public static void main(String[] args) {
        List list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.pushBack(i);
        }
        System.out.println(list);
        list.popBack();
        System.out.println(list);
        for (int i = 0; i < 10; i++) list.popBack();
        System.out.println(list);
        list.insert(0, 10);
        System.out.println(list);
        for(int i=0; i<4; i++) {
            list.pushBack(i);
        }
        list.insert(2, 8);
        System.out.println(list);
    }
}
