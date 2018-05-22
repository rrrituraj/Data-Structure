package Array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SmallestSubArray {

    public static void main(String[] args) {
        int[] arr = new int[]{-8, 1, 4, 2, -6};
        subArray(arr, 6);
    }

    private static void subArray(int[] arr, int value) {
        Map<Integer, int[]> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum > value) {
                    int length = j - i + 1;
                    int[] arr1 = new int[length];
                    System.arraycopy(arr, i, arr1, 0, length);
                    map.putIfAbsent(length, arr1);
                    break;
                }
            }
            sum = 0;
        }
        Integer min = Collections.min(map.keySet());
        System.out.println(min);
        int[] ints = map.get(min);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
