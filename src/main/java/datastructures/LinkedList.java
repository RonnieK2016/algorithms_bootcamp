package datastructures;

import java.util.NoSuchElementException;

public class LinkedList<T> {

    private Node head;
    private Node tail;

    private int size;

    public void add(T value) {
        addLast(value);
    }

    public void addFirst(T value) {
        if(size == 0) {
            head = new Node(value);
            tail = head;
        }
        else {
            head = new Node(value, head);
        }

        size++;
    }

    public void addLast(T value) {
        if(size == 0) {
            head = new Node(value);
            tail = head;
        }
        else {
            Node tmpNode = new Node(value);
            tail.next = tmpNode;
            tail = tmpNode;
        }

        size++;
    }

    public T getFirst() {
        if(size == 0) {
            throw new NoSuchElementException("List is empty");
        }

        return head.value;
    }

    public T getLast() {
        if(size == 0) {
            throw new NoSuchElementException("List is empty");
        }

        return tail.value;
    }

    public T remove() {
        return removeFirst();
    }

    public T removeFirst() {
        if(size == 0) {
            throw new NoSuchElementException("List is empty");
        }

        T val = head.value;

        if(size == 1) {
            head = tail = null;
        }
        else {
            head = head.next;
        }

        size--;

        return val;
    }

    public T removeLast() {
        if(size == 0) {
            throw new NoSuchElementException("List is empty");
        }

        T val = tail.value;

        if(size == 1) {
            head = tail = null;
        }
        else {
            Node curNode = head;
            Node prevNode = null;
            while(curNode.next != null) {
                prevNode = curNode;
                curNode = curNode.next;
            }
            prevNode.next = null;
            tail = prevNode;
        }

        size--;

        return val;
    }

    public boolean remove(T value) {
        if(size == 0) {
            throw new NoSuchElementException("List is empty");
        }

        boolean isRemoved = false;
        Node prevNode = null;
        Node curNode = head;
        while(curNode != null) {
            if(curNode.value.equals(value)) {
                break;
            }
            prevNode = curNode;
            curNode = curNode.next;
        }

        //if we found node
        if(curNode != null) {
            //the middle or the end of the list
            if(prevNode != null) {
                prevNode.next = curNode.next;
                if(curNode == tail) {
                    tail = prevNode;
                }
            }
            else {
                if(curNode == head) {
                    head = curNode.next;
                }
                if(curNode == tail) {
                    tail = null;
                }
            }

            size--;
            isRemoved = true;
        }

        return isRemoved;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {

        private Node next;
        private T value;

        Node(T inpValue) {
            this.value = inpValue;
        }

        Node(T inpValue, Node nextNode) {
            this.value = inpValue;
            this.next = nextNode;
        }
    }
}
