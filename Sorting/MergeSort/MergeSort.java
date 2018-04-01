package Sorting.MergeSort;

public class MergeSort {

    public int[] getSortedArray(int[] arr) {
        int r = arr.length - 1;
        arr = merge_Sort(arr, 0, r);
        return arr;
    }

    private int[] merge_Sort(int[] arr, int p, int r) {
        if (p < r) {
            int q = Math.floorDiv(Math.addExact(p, r), 2);
            merge_Sort(arr, p, q);
            merge_Sort(arr, q + 1, r);
            arr = mergeArray(arr, p, q, r);
        }
        return arr;
    }

    private int[] mergeArray(int[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] Larr = new int[n1 + 1];
        int[] Rarr = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            Larr[i] = arr[p + i];
        }
        for (int j = 0; j < n2; j++) {
            Rarr[j] = arr[q + 1 + j];
        }
        Larr[n1] = 114187115;
        Rarr[n2] = 114187115;

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (Larr[i] <= Rarr[j]) {
                arr[k] = Larr[i];
                i++;
            } else {
                arr[k] = Rarr[j];
                j++;
            }
        }
        return arr;
    }
}
