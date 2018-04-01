package Sorting.HeapSort;

public class HeapOperations {
    public int heapExtractMax(int[] arr) {
        int heapSize = arr.length - 1;
        if (heapSize < 0) {
            throw new Error("heapSize is Less than zero");
        }
        int max = arr[0];
        arr[0] = arr[heapSize];
        heapSize--;
        new MaximumHeap().buildMaxHeap(arr);
        return max;
    }

    public int[] heapIncreaseKey(int[] arr, int i, int key) {
        i = i - 1;
        if (key < arr[i]) {
            throw new Error("key is leass than the value present at that place");
        }
        arr[i] = key;
        while (i > 0 && arr[Math.floorDiv(i - 1, 2)] < arr[i]) {
            new MaximumHeap().exchangeNumber(arr, i, Math.floorDiv(i - 1, 2));
            i = Math.floorDiv(i - 1, 2);
        }
        return arr;
    }
}
