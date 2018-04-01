package Sorting.QuickSort;

public class QuickSortClient {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 3, 2, 6, 4, 8, 9, 7, 0, 7};
        arr = new QuickSort().getSortedArray(arr);
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }
}
