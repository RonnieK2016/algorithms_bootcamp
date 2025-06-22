package sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class BubbleSortTest {

    @Test
    void sortIntArray() {
        int[] inpArray = new int[1000];
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> BubbleSort.sortIntArray(new int[0]));
        for(int i = 0; i < inpArray.length; i++) {
            inpArray[i] = new Random().nextInt(10000);
        }
        BubbleSort.sortIntArray(inpArray);
        for(int i = 1; i < inpArray.length; i++) {
            Assertions.assertTrue(inpArray[i] >= inpArray[i -1]);
        }
    }
}