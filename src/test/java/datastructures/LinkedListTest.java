package datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void add() {
        addLast();
    }

    @Test
    void addFirst() {
        LinkedList<Integer> ls = new LinkedList<>();
        Assertions.assertEquals(0, ls.size());
        ls.addFirst(1);
        Assertions.assertEquals(1, ls.getFirst());
        ls.addFirst(2);
        Assertions.assertEquals(2, ls.getFirst());
        ls.addFirst(3);
        Assertions.assertEquals(3, ls.getFirst());
    }

    @Test
    void addLast() {
        LinkedList<Integer> ls = new LinkedList<>();
        Assertions.assertEquals(0, ls.size());
        ls.addLast(1);
        Assertions.assertEquals(1, ls.getLast());
        Assertions.assertEquals(1, ls.getFirst());
        ls.addLast(2);
        Assertions.assertEquals(1, ls.getFirst());
        Assertions.assertEquals(2, ls.getLast());
        ls.addLast(3);
        Assertions.assertEquals(1, ls.getFirst());
        Assertions.assertEquals(3, ls.getLast());
    }

    @Test
    void getFirst() {
        LinkedList<Integer> ls = new LinkedList<>();
        Assertions.assertEquals(0, ls.size());
        ls.add(1);
        ls.add(2);
        ls.add(3);
        Assertions.assertEquals(1, ls.getFirst());
        ls.removeFirst();
        Assertions.assertEquals(2, ls.getFirst());
    }

    @Test
    void getLast() {
        LinkedList<Integer> ls = new LinkedList<>();
        Assertions.assertEquals(0, ls.size());
        ls.add(1);
        ls.add(2);
        ls.add(3);
        Assertions.assertEquals(3, ls.getLast());
        ls.removeLast();
        Assertions.assertEquals(2, ls.getLast());
    }

    @Test
    void remove() {
        removeFirst();
    }

    @Test
    void removeFirst() {
        LinkedList<Integer> ls = new LinkedList<>();
        Assertions.assertEquals(0, ls.size());
        ls.add(1);
        ls.add(2);
        ls.add(3);
        Assertions.assertEquals(3, ls.size());
        Assertions.assertEquals(1, ls.removeFirst());
        Assertions.assertEquals(2, ls.removeFirst());
        Assertions.assertEquals(3, ls.removeFirst());
        Assertions.assertEquals(0, ls.size());
    }

    @Test
    void removeLast() {
        LinkedList<Integer> ls = new LinkedList<>();
        Assertions.assertEquals(0, ls.size());
        ls.add(1);
        ls.add(2);
        ls.add(3);
        Assertions.assertEquals(3, ls.size());
        Assertions.assertEquals(3, ls.removeLast());
        Assertions.assertEquals(2, ls.removeLast());
        Assertions.assertEquals(1, ls.removeLast());
        Assertions.assertEquals(0, ls.size());
    }

    @Test
    void size() {
        LinkedList<Integer> ls = new LinkedList<>();
        Assertions.assertEquals(0, ls.size());
        ls.add(1);
        ls.add(2);
        ls.add(3);
        Assertions.assertEquals(3, ls.size());
        Assertions.assertEquals(3, ls.removeLast());
        Assertions.assertEquals(2, ls.removeLast());
        Assertions.assertEquals(1, ls.removeLast());
        Assertions.assertEquals(0, ls.size());
    }

    @Test
    void isEmpty() {
        LinkedList<Integer> ls = new LinkedList<>();
        Assertions.assertTrue(ls.isEmpty());
        ls.add(1);
        Assertions.assertFalse(ls.isEmpty());
        ls.remove();
        Assertions.assertTrue(ls.isEmpty());
    }

    @Test
    void indexOf() {
        LinkedList<Integer> ls = new LinkedList<>();
        Assertions.assertEquals(0, ls.size());
        ls.addFirst(1);
        ls.addFirst(2);
        ls.addFirst(3);
        Assertions.assertEquals(1, ls.indexOf(3));
        Assertions.assertEquals(2, ls.indexOf(2));
        Assertions.assertEquals(3, ls.indexOf(1));
    }

    @Test
    void removeWithValue() {
        LinkedList<Integer> ls = new LinkedList<>();
        Assertions.assertEquals(0, ls.size());
        for(int i = 0; i < 100; i++) {
            ls.add(i);
        }
        Assertions.assertEquals(100, ls.size());
        Assertions.assertTrue(ls.remove(55));
        Assertions.assertTrue(ls.remove(34));
        Assertions.assertTrue(ls.remove(12));
    }
}