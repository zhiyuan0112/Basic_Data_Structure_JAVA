package datastructure;

public class ArrayList<E> implements List<E> {
    public static int MIN_CAPACITY = 10;
    public static int EXPAND_RATIO = 2;

    private int capacity = MIN_CAPACITY;
    private int size = 0;
    private E[] data;

    ArrayList() {
        data = (E[]) new Object[capacity];
    }

    private void resizeIfNeed() {
        if(capacity == MIN_CAPACITY || size > capacity/EXPAND_RATIO && size < capacity)
            return;
        if (size == capacity) {
            capacity *= EXPAND_RATIO;
        } else if (size == capacity / EXPAND_RATIO) {
            capacity /= EXPAND_RATIO;
        }
        E[] new_data = (E[]) new Object[capacity];
        System.arraycopy(data, 0, new_data, 0, size);
        data = new_data;
    }

    @Override
    public void add(E val) {
        size++;
        resizeIfNeed();
        data[size-1] = val;
    }

    @Override
    public void add(int idx, E e) {
        if (idx > size || size < 0) return;
        E tmp = data[size - 1];
        for (int i = size - 1; i > idx; i--) {
            data[i + 1] = data[i];
        }
        data[idx] = e;
        add(tmp);
    }

    @Override
    public void remove() {
        if (size == 0) return;
        size--;
        resizeIfNeed();
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
        return data[idx];
    }

    @Override
    public E set(int idx) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i != 0) builder.append(", ");
            builder.append(data[i]);
        }
        return "ArrayList{" +
                "MAX_LEN=" + capacity +
                ", len=" + size +
                ", data=" + builder +
                '}';
    }

    public E[] getData() {
        return data;
    }
}
