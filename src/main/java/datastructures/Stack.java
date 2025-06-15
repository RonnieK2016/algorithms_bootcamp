package datastructures;

import java.util.EmptyStackException;

public class Stack<T> {
    final private LinkedList<T> list;
    public Stack() {
        list = new LinkedList<>();
    }

    public T peek() {
        if(list.isEmpty()) {
            throw new EmptyStackException();
        }

        return list.getFirst();
    }

    public void push(T value) {
        list.addFirst(value);
    }

    public T pop() {
        if(list.isEmpty()) {
            throw new EmptyStackException();
        }

        return list.removeFirst();
    }

    public int search(T value) {
        return list.indexOf(value);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
