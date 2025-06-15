package datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void add() {
        Queue<Integer> q = new Queue<>();
        Assertions.assertTrue(q.isEmpty());
        q.add(1);
        q.add(2);
        q.add(3);
        Assertions.assertEquals(1, q.peek());
        q.poll();
        Assertions.assertEquals(2, q.peek());
        q.poll();
        Assertions.assertEquals(3, q.peek());
    }

    @Test
    void addLimitedCapacity() {
        Queue<Integer> q = new Queue<>(3);
        Assertions.assertTrue(q.isEmpty());
        q.add(1);
        q.add(2);
        q.add(3);
        Assertions.assertThrows(IllegalStateException.class, () ->  q.add(4));
    }

    @Test
    void offer() {
        peek();
    }

    @Test
    void offerLimitedCapcity() {
        Queue<Integer> q = new Queue<>(3);
        Assertions.assertTrue(q.isEmpty());
        Assertions.assertTrue(q.offer(1));
        Assertions.assertTrue(q.offer(2));
        Assertions.assertTrue(q.offer(3));
        Assertions.assertFalse(q.offer(4));
    }

    @Test
    void peek() {
        Queue<Integer> q = new Queue<>();
        Assertions.assertTrue(q.isEmpty());
        q.offer(1);
        q.offer(2);
        q.offer(3);
        Assertions.assertEquals(1, q.peek());
        q.poll();
        Assertions.assertEquals(2, q.peek());
        q.poll();
        Assertions.assertEquals(3, q.peek());
    }

    @Test
    void poll() {
        Queue<Integer> q = new Queue<>();
        Assertions.assertTrue(q.isEmpty());
        q.offer(1);
        q.offer(2);
        q.offer(3);
        Assertions.assertEquals(1, q.poll());
        Assertions.assertEquals(2, q.poll());
        Assertions.assertEquals(3, q.poll());
    }

    @Test
    void search() {
        Queue<Integer> q = new Queue<>();
        Assertions.assertTrue(q.isEmpty());
        q.offer(1);
        q.offer(2);
        q.offer(3);
        Assertions.assertEquals(3, q.search(3));
        Assertions.assertEquals(2, q.search(2));
        Assertions.assertEquals(1, q.search(1));
        Assertions.assertEquals(-1, q.search(4));
    }

    @Test
    void isEmpty() {
        Queue<Integer> q = new Queue<>();
        Assertions.assertTrue(q.isEmpty());
        q.offer(1);
        q.offer(2);
        q.offer(3);
        Assertions.assertFalse(q.isEmpty());
        while(!q.isEmpty()) {
            q.poll();
        }
        Assertions.assertTrue(q.isEmpty());
    }

    @Test
    void size() {
        Queue<Integer> q = new Queue<>();
        Assertions.assertEquals(0, q.size());
        q.offer(1);
        q.offer(2);
        q.offer(3);
        Assertions.assertEquals(3, q.size());
        while(!q.isEmpty()) {
            q.poll();
        }
        Assertions.assertEquals(0, q.size());
    }
}