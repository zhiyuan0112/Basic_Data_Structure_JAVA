import java.util.Arrays;

public class ArrayList implements List{
    private int MAX_LEN = 10;
    private int len = 0;
    private int[] data = new int[MAX_LEN];

    private void copyData() {
        int[] new_data = new int[MAX_LEN];
        if (len >= 0) System.arraycopy(data, 0, new_data, 0, len);
        data = new_data;
    }

    @Override
    public void pushBack(int val) {
        if (len == MAX_LEN) {
            MAX_LEN *= 2;
            copyData();
        }
        data[len] = val;
        len++;
    }

    @Override
    public void popBack() {
        if (len == 0) return;
        len--;
        if (len == MAX_LEN/2 && len > 10) {
            MAX_LEN /= 2;
            copyData();
        }
    }
//    1,2,3 (3,10)
    @Override
    public void insert(int idx, int val) {
        if (idx < 0 || idx > len) return;
        for (int i = idx; i < len; i++) {
            int temp = data[i];
            data[i] = val;
            val = temp;
        }
        pushBack(val);
    }

    @Override
    public int size() {
        return len;
    }

    @Override
    public String toString() {
        StringBuilder data_str = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i != 0) data_str.append(", ");
            data_str.append(data[i]);
        }
        return "ArrayList{" +
                "MAX_LEN=" + MAX_LEN +
                ", len=" + len +
                ", data=" + data_str +
                '}';
    }
}
