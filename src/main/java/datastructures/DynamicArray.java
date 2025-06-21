package datastructures;

public class DynamicArray<T> {

    final private static  int DEFAULT_CAPACITY = 10;
    private Object[] values;
    private int size = 0;

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArray(int capacity) {
        if(capacity <= 0) {
            throw new IllegalArgumentException("Capacity should be greater than 0");
        }
        values = new Object[capacity];
    }

    private void checkIndex(int index) {
        if(index > size || index < 0) {
            throw new IndexOutOfBoundsException("Cannot delete element at index " + index);
        }
    }

    public T get(int index) {
        checkIndex(index);

        return (T) values[index];
    }

    public void add(T value) {
        ensureCapacity(size + 1);
        values[size++] = value;
    }

    public void insert(int index, T value) {
        checkIndex(index);
        ensureCapacity(size + 1);

        if(index != size) {
            System.arraycopy(values, index, values, index + 1, size - index);
        }

        values[index] = value;
        size++;
    }

    public void set(int index, T value) {
        checkIndex(index);

        values[index] = value;
    }

    public T delete(int index) {
        checkIndex(index);

        Object value = values[index];

        if((index - 1) == size) {
            values[index] = null;
        }
        else {
            System.arraycopy(values, index + 1, values, index, size - index - 1);
        }
        size--;

        compressArray();

        return (T) value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity(int newSize) {
        if(newSize == values.length) {
            Object[] newValues = new Object[values.length * 2];
            System.arraycopy(values, 0, newValues, 0, values.length);
            values = newValues;
        }
    }

    private void compressArray() {
        int newHalf =  values.length / 4;
        if(size < newHalf && (newHalf * 2)  > DEFAULT_CAPACITY) {
            Object[] newValues = new Object[newHalf * 2];
            System.arraycopy(values, 0, newValues, 0, size);
            values = newValues;
        }
    }
}
