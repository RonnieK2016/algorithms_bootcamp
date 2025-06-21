package datastructures;

import java.util.NoSuchElementException;

public class Queue<T> {

    final private LinkedList<T> list;

    private int capacity;

    public Queue() {
        this.list = new LinkedList<>();
    }

    public Queue(int capacity) {
        this.list = new LinkedList<>();
        this.capacity = capacity;
    }

    public void add(T value) {
        if(this.capacity > 0 && ((list.size() + 1) > capacity)) {
            throw new IllegalStateException("Queue is full. Maximum size: " + this.capacity);
        }

        list.addLast(value);
    }

    public boolean offer(T value) {
        if(capacity > 0 && (list.size() + 1) > capacity) {
            return false;
        }

        list.addLast(value);

        return true;
    }

    public T peek() {
        if(list.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return list.getFirst();
    }

    public T poll() {
        if(list.isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return list.removeFirst();
    }

    public int search(T value) {
        return list.indexOf(value);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
