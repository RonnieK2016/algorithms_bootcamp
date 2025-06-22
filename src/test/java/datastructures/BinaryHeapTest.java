package datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {

    @Test
    void insert() {
        BinaryHeap<Integer> bh = new BinaryHeap<>();
        bh.insert(10);
        bh.insert(5);
        bh.insert(4);
        bh.insert(3);
        bh.insert(2);
        Assertions.assertEquals(5, bh.size());
        Assertions.assertEquals(2, bh.peek());
    }

    @Test
    void peek() {
        BinaryHeap<Integer> bh = new BinaryHeap<>();
        Assertions.assertThrows(IllegalStateException.class, bh::peek);
        bh.insert(10);
        Assertions.assertEquals(10, bh.peek());
        bh.insert(5);
        Assertions.assertEquals(5, bh.peek());
        bh.insert(4);
        Assertions.assertEquals(4, bh.peek());
        bh.insert(3);
        Assertions.assertEquals(3, bh.peek());
        bh.insert(2);
        Assertions.assertEquals(2, bh.peek());
    }

    @Test
    void poll() {
        BinaryHeap<Integer> bh = new BinaryHeap<>();
        Assertions.assertThrows(IllegalStateException.class, bh::poll);
        bh.insert(10);
        bh.insert(5);
        bh.insert(4);
        bh.insert(3);
        bh.insert(2);
        Assertions.assertEquals(2, bh.poll());
        Assertions.assertEquals(3, bh.poll());
        Assertions.assertEquals(4, bh.poll());
        Assertions.assertEquals(5, bh.poll());
        Assertions.assertEquals(10, bh.poll());
    }

    @Test
    void pollWithDescComparator() {
        BinaryHeap<Integer> bh = new BinaryHeap<>((a, b) -> Integer.compare(b, a));
        bh.insert(10);
        bh.insert(5);
        bh.insert(4);
        bh.insert(3);
        bh.insert(2);
        Assertions.assertEquals(10, bh.poll());
        Assertions.assertEquals(5, bh.poll());
        Assertions.assertEquals(4, bh.poll());
        Assertions.assertEquals(3, bh.poll());
        Assertions.assertEquals(2, bh.poll());
    }

    @Test
    void pollTestWithRandomAscendingArray() {
        int[] randomIntsArray = IntStream.generate(()
                -> new Random().nextInt(1000))
                .limit(1000).toArray();
        BinaryHeap<Integer> bh = new BinaryHeap<>();
        for (int el : randomIntsArray) {
            bh.insert(el);
        }
        Arrays.sort(randomIntsArray);
        for (int el : randomIntsArray) {
            Assertions.assertEquals(el, bh.poll());
        }
    }

    @Test
    void pollTestWithRandomAscendingArrayComparator() {
        int[] randomIntsArray = IntStream.generate(()
                        -> new Random().nextInt(1000))
                .limit(1000).toArray();
        BinaryHeap<Integer> bh = new BinaryHeap<>(Integer::compare);
        for (int el : randomIntsArray) {
            bh.insert(el);
        }
        Arrays.sort(randomIntsArray);
        for (int el : randomIntsArray) {
            Assertions.assertEquals(el, bh.poll());
        }
    }

    @Test
    void isEmpty() {
        BinaryHeap<Integer> bh = new BinaryHeap<>();
        Assertions.assertTrue(bh.isEmpty());
        bh.insert(2);
        bh.insert(3);
        bh.insert(4);
        Assertions.assertFalse(bh.isEmpty());
    }

    @Test
    void size() {
        BinaryHeap<Integer> bh = new BinaryHeap<>();
        Assertions.assertEquals(0, bh.size());
        bh.insert(2);
        bh.insert(3);
        bh.insert(4);
        Assertions.assertEquals(3, bh.size());
    }
}