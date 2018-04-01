package Sorting.HeapSort;

public class HeapSortClient {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 2, 3, 6, 4, 8, 9, 11};
        int[] maxHeap = new MaximumHeap().buildMaxHeap(arr);
        System.out.println("..............maxHeap......................");
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        int deleteMax = new HeapOperations().heapExtractMax(maxHeap);
        System.out.println("\n..............after max heap node deleted......................");
        for (int i : arr) {
            System.out.print(i + "\t");
        }
        System.out.println("\n..............after increasing a key in heap ......................");
        int[] increasedKeyArray = new HeapOperations().heapIncreaseKey(arr, 4, 50);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }
}
