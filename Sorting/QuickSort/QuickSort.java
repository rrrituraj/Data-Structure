package Sorting.QuickSort;

public class QuickSort {

    private int[] swappedArray(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    private int partitionOfArrayUsingPivote(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j] <= x) {
                i++;
                arr = swappedArray(arr, i, j);
            }
        }
        swappedArray(arr, i + 1, r);
        return i + 1;
    }

    public int[] getSortedArray(int[] arr) {
        int r = arr.length - 1;
        arr = quick_Sort(arr, 0, r);
        return arr;
    }

    private int[] quick_Sort(int[] arr, int p, int r) {

        if (p < r) {
            int q = partitionOfArrayUsingPivote(arr, p, r);
            quick_Sort(arr, p, q - 1);
            quick_Sort(arr, q + 1, r);
        }
        return arr;
    }
}
