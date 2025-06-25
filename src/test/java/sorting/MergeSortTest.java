package sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class MergeSortTest {

    @Test
    void mergeSort() {
        for(int i = 0; i < 100; i++) {
            int size = new Random().nextInt(100000);
            int bound = new Random().nextInt(100000);
            mergeSortForInput(size, bound);
        }
    }

    private void mergeSortForInput(int size, int bound) {
        size = size == 0 ? 1000 : size;

        System.out.println("Running for size " + size + " bound " + bound);

        int[] inpArray = new int[size];
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> MergeSort.sortIntArray(new int[0]));
        for(int i = 0; i < inpArray.length; i++) {
            inpArray[i] = new Random().nextInt(bound);
        }

        MergeSort.sortIntArray(inpArray);
        for(int i = 1; i < inpArray.length; i++) {
            Assertions.assertTrue(inpArray[i] >= inpArray[i -1]);
        }
    }
}