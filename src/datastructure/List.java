package datastructure;

public interface List<E> {
    void add(E e);
    void add(int idx, E e);
    void remove();
    void remove(int idx);
    int size();
    E get(int idx);
    E set(int idx);
}
