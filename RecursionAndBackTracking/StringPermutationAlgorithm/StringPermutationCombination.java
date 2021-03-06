package RecursionAndBackTracking.StringPermutationAlgorithm;

import java.util.Map;
import java.util.TreeMap;

public class StringPermutationCombination {
    public void permute(char input[]) {
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : input) {
            countMap.compute(
                    ch,
                    (k, v) -> {
                        if (v == null) {
                            return 1;
                        } else {
                            return v + 1;
                        }
                    });
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        char result[] = new char[input.length];
        permuteUtil(str, count, result, 0);
        // combination(str, count, 0, result, 0);
    }

    public void combination(char input[]) {
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : input) {
            countMap.compute(
                    ch,
                    (k, v) -> {
                        if (v == null) {
                            return 1;
                        } else {
                            return v + 1;
                        }
                    });
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        char result[] = new char[input.length];
        // permuteUtil(str, count, result, 0);
        combination(str, count, 0, result, 0);
    }

    private void combination(char[] str, int[] count, int pos, char[] result, int len) {
        print(result, len);
        for (int i = pos; i < str.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            result[len] = str[i];
            count[i]--;
            combination(str, count, i, result, len + 1);
            count[i]++;
        }
    }

    private void permuteUtil(char[] str, int[] count, char[] result, int level) {
        if (level == result.length) {
            printArray(result);
            return;
        }
        for (int i = 0; i < str.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1);
            count[i]++;
        }
    }

    private void printArray(char[] result) {
        for (char ch : result) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }

    private void print(char[] result, int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(result[i] + "  ");
        }
        System.out.println();
    }
}
