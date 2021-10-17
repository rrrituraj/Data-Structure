package heap;

import java.util.Arrays;

class Heap {
    int[] heap;

    public static void main(String[] args) {
        Heap heapIns = new Heap();
        heapIns.initializeHeap();
        System.out.println(Arrays.toString(heapIns.heap));
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
}