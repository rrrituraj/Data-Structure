package Sorting.HeapSort;

public class HeapSortClient {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 2, 3, 6, 4, 8, 9,};
        int[] maxHeap = new BuildMaximumHeap().buildMaxHeap(arr);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}
