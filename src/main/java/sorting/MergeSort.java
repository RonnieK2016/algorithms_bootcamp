package sorting;

public class MergeSort {

    private static void mergeArrays(int[] array, int left, int right, int mid) {
        //first array from left to mid including
        //second array from mid excluding to right including
        int i = left;
        int j = mid + 1;
        int[] tempArr = new int[right - left + 1];
        int k = 0;
        while(i <= mid || j <= right) {
            int leftEl = i <= mid ? array[i] : Integer.MAX_VALUE;
            int rightEl = j <= right ? array[j] : Integer.MAX_VALUE;
            if(leftEl <= rightEl) {
                tempArr[k++] = leftEl;
                i++;
            }
            else {
                tempArr[k++] = rightEl;
                j++;
            }
        }
        System.arraycopy(tempArr, 0, array, left, tempArr.length);
    }

    private static void mergeSort(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }

        int mid = (left + right)/2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        mergeArrays(array, left, right, mid);
    }

    public static void sortIntArray(int[] array) {
        if(array.length == 0) {
            throw new IllegalArgumentException("Input array cannot be empty");
        }

        mergeSort(array, 0, array.length - 1);
    }
}
