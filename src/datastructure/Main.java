package datastructure;

public class Main {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            list.add(9.9);
        }
        System.out.println(list);
        for (int i = 0; i < 10; i++) {
            list.remove();
        }
        System.out.println(list);
        for (int i = 0; i < 6; i++) {
            list.add(10.1);
        }
        System.out.println(list);
        list.add(0,8.2);
        list.add(6,5.0);
        System.out.println(list);
    }
}
