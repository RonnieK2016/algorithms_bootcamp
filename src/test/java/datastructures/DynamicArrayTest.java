package datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DynamicArrayTest {

    @Test
    void get() {
        DynamicArray<Integer> dr  = new DynamicArray<>();
        for(int i = 0; i < 100; i++) {
            dr.add(i);
        }

        for(int i = 0; i < 100; i++) {
            Assertions.assertEquals(i, dr.get(i));
        }
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> dr.get(1000));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> dr.get(-10));
    }

    @Test
    void insert() {
        DynamicArray<Integer> dr  = new DynamicArray<>();
        dr.add(0);
        dr.add(1);
        dr.add(2);
        dr.insert(1, 3);
        dr.insert(4, 4);

        Assertions.assertEquals(3, dr.get(1));
        Assertions.assertEquals(1, dr.get(2));
        Assertions.assertEquals(4, dr.get(4));
    }

    @Test
    void set() {
        DynamicArray<Integer> dr  = new DynamicArray<>();
        dr.add(0);
        dr.add(1);
        dr.add(2);
        dr.set(1, 3);
        dr.set(2, 4);

        Assertions.assertEquals(3, dr.get(1));
        Assertions.assertEquals(4, dr.get(2));
    }

    @Test
    void delete() {
        DynamicArray<Integer> dr  = new DynamicArray<>();
        dr.add(0);
        dr.add(1);
        dr.add(2);
        Assertions.assertFalse(dr.isEmpty());
        Assertions.assertEquals(1, dr.delete(1));
        Assertions.assertEquals(2, dr.delete(1));
        Assertions.assertEquals(0, dr.delete(0));
        Assertions.assertTrue(dr.isEmpty());
    }

    @Test
    void isEmpty() {
        DynamicArray<Integer> dr  = new DynamicArray<>();

        Assertions.assertTrue(dr.isEmpty());
        dr.add(0);
        dr.add(1);
        dr.add(2);
        Assertions.assertFalse(dr.isEmpty());
    }

    @Test
    void size() {
        DynamicArray<Integer> dr  = new DynamicArray<>();

        Assertions.assertEquals(0 ,dr.size());
        dr.add(0);
        dr.add(1);
        dr.add(2);
        Assertions.assertEquals(3 ,dr.size());
        dr.delete(2);
        Assertions.assertEquals(2 ,dr.size());
    }

    @Test
    void illegalCapacity() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new DynamicArray<>(0));
    }

}