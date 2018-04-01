package Sorting.HeapSort;

public class MaximumHeap {
    private int heapSize;

    public int[] buildMaxHeap(int[] arr) {
        heapSize = arr.length - 1;
        for (int i = Math.floorDiv(arr.length - 1, 2); i >= 0; i--) {
            maxHeapiFy(arr, i);
        }
        return arr;
    }

    /**
     * @param arr takes an array with index i
     * @param i   index or root node
     * @return Heapified Array
     */
    @SuppressWarnings("InfiniteRecursion")
    public int[] maxHeapiFy(int[] arr, int i) {
        int l, r;

        l = 2 * i + 1;
        r = 2 * i + 2;

        int largest;
        if (l <= heapSize && arr[l] > arr[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= heapSize && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            exchangeNumber(arr, i, largest);
            maxHeapiFy(arr, largest);
        }

        return arr;
    }

    public void exchangeNumber(int[] arr, int i, int largest) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
    }
}
