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
        int[] L_arr = new int[n1 + 1];
        int[] R_arr = new int[n2 + 1];
        System.arraycopy(arr, p, L_arr, 0, n1);
        System.arraycopy(arr, q + 1, R_arr, 0, n2);

        L_arr[n1] = Integer.MAX_VALUE;
        R_arr[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (L_arr[i] <= R_arr[j]) {
                arr[k] = L_arr[i];
                i++;
            } else {
                arr[k] = R_arr[j];
                j++;
            }
        }
        return arr;
    }
}
