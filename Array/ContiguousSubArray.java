package Array;

import java.util.ArrayList;
import java.util.List;

public class ContiguousSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        List<List<Integer>> lists = new ArrayList<>();
        int q = 0;
        List<Integer> lst = null;
        findSubArray(arr, lists);
        for (List l : lists) {
            if (q < l.size()) {
                q = l.size();
                lst = l;
            }
        }
        System.out.println("total size is: " + q + "  and longest contiguous subarray is:  " + lst);
    }

    private static void findSubArray(int[] arr, List<List<Integer>> lists) {
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();

            int j = i;
            while (j < arr.length - 1 && arr[j] - arr[j + 1] == 1) {
                if (j == i) {
                    list.add(arr[i]);
                }
                list.add(arr[j + 1]);
                j++;
            }
            i = j;
            if (!list.isEmpty()) {
                //        System.out.println(list);
                lists.add(list);
            }

            while (j < arr.length - 1 && arr[j + 1] - arr[j] == 1) {
                if (j == i) {
                    list1.add(arr[i]);
                }
                list1.add(arr[j + 1]);
                j++;
            }
            i = j;
            if (!list1.isEmpty()) {
                //        System.out.println(list1);
                lists.add(list1);
            }
        }
    }
}
