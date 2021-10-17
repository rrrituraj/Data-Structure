package heap;

import java.util.Arrays;

import static java.lang.System.out;

class Heap {
    int[] heap;
    int heapSize;

    public static void main(String[] args) {
        Heap heapIns = new Heap();
        int[] randomArray = new int[]{40, 35, 12, 30, 6, 10, 15, 20, 15};
        heapIns.heapSize = randomArray.length;
//        heapIns.initializeHeap();
        heapIns.heap = randomArray;
//        heapIns.buildMaxHeapify(heapIns.heap);
        heapIns.heapSort(heapIns.heap);
//        System.out.println(Arrays.toString(heapIns.heap));
    }

    void initializeHeap() {
        int[] randomArray = new int[]{40, 35, 12, 30, 6, 10, 15, 20, 15};
        heap = randomArray;
        for (int i = 0; i < randomArray.length; i++) {
            insertInHeap(heap, i);
        }
    }

    public void insertInHeap(int[] A, int n) {
        int i, temp;
        i = n;
        temp = A[n];
        while (i > 0 && temp > A[(i - 1) / 2]) {
            A[i] = A[(i - 1) / 2];
            i = (i - 1) / 2;
        }
        A[i] = temp;
    }


    public int[] buildMaxHeapify(int[] A) {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            int[] heapifiedArray = maxHeapify(A, i);
            A = heapifiedArray;
        }
        return A;
    }

    public void heapSort(int[] A) {

        while (heapSize >0) {
            int[] heapArray = buildMaxHeapify(A);
            out.println(heapArray[0]);
            heapArray[0] = heapArray[heapSize - 1];
            heapSize--;
        }
    }

    private int[] maxHeapify(int[] A, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest;
        largest = (l < heapSize && A[l] > A[i]) ? l : i;
        largest = (r < heapSize && A[r] > A[largest]) ? r : largest;
        if (largest != i) {
            exchange(A, largest, i);
            maxHeapify(A, largest);
        }
        return A;
    }

    private int[] minHeapify(int[] A, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest;
        largest = (l < heapSize && A[l] < A[i]) ? l : i;
        largest = (r < heapSize && A[r] < A[largest]) ? r : largest;
        if (largest != i) {
            exchange(A, largest, i);
            minHeapify(A, largest);
        }
        return A;
    }

    private void exchange(int[] A, int largest, int i) {
        int temp = A[largest];
        A[largest] = A[i];
        A[i] = temp;
    }
}