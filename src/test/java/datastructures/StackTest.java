package datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void peek() {
        Stack<Integer> st = new Stack<>();
        Assertions.assertTrue(st.isEmpty());
        st.push(1);
        Assertions.assertEquals(1, st.peek());
        st.push(2);
        Assertions.assertEquals(2, st.peek());
        st.push(3);
        Assertions.assertEquals(3, st.peek());
    }

    @Test
    void push() {
        Stack<Integer> st = new Stack<>();
        Assertions.assertTrue(st.isEmpty());
        st.push(1);
        Assertions.assertEquals(1, st.size());
        st.push(2);
        Assertions.assertEquals(2, st.size());
        st.push(3);
        Assertions.assertEquals(3, st.size());
    }

    @Test
    void pop() {
        Stack<Integer> st = new Stack<>();
        Assertions.assertTrue(st.isEmpty());
        st.push(1);
        st.push(2);
        st.push(3);
        Assertions.assertEquals(3, st.pop());
        Assertions.assertEquals(2, st.pop());
        Assertions.assertEquals(1, st.pop());
    }

    @Test
    void search() {
        Stack<Integer> st = new Stack<>();
        Assertions.assertTrue(st.isEmpty());
        st.push(1);
        st.push(2);
        st.push(3);
        Assertions.assertEquals(1, st.search(3));
        Assertions.assertEquals(2, st.search(2));
        Assertions.assertEquals(3, st.search(1));
        Assertions.assertEquals(-1, st.search(4));
    }

    @Test
    void isEmpty() {
        Stack<Integer> st = new Stack<>();
        Assertions.assertTrue(st.isEmpty());
        st.push(1);
        Assertions.assertFalse(st.isEmpty());
        st.pop();
        Assertions.assertTrue(st.isEmpty());
    }

    @Test
    void size() {
        Stack<Integer> st = new Stack<>();
        Assertions.assertEquals(0, st.size());
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        Assertions.assertEquals(4, st.size());
        while(!st.isEmpty()) {
            st.pop();
        }
        Assertions.assertEquals(0, st.size());
    }
}