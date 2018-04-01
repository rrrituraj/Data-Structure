package Sorting.MergeSort;

public class MergeSortClient {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = new int[]{1, 5, 3, 2, 6, 4, 5, 6, 6, 9, 8, 9, 7};
        mergeSort.getSortedArray(arr);
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }
}
