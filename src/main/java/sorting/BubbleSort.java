package sorting;

public class BubbleSort {
    public static void sortIntArray(int[] nums) {
        if(nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be empty");
        }

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
