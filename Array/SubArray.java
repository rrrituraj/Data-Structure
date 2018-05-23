package Array;

public class SubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        int value = 7;
        subsetArray(arr, value);
    }

    private static void subsetArray(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    if (i != j && j != k && k != i) {
//            System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                        subSetSum(arr[i], arr[j], arr[k], value);
                    }
                }
            }
        }
    }

    private static void subSetSum(int i, int j, int k, int value) {
        int sum = i + j + k;
        if (sum < value) {
            System.out.println("sum is: " + sum + " which is less than " + value + " and subset is:   " + i + " " + j + " " + k);
        }
    }
}
