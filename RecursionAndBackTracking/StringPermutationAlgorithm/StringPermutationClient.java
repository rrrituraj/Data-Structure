package RecursionAndBackTracking.StringPermutationAlgorithm;

public class StringPermutationClient {
    public static void main(String[] args) {
        char input[] = new char[]{'A', 'A', 'B', 'B', 'C', 'C', 'C'};
        new StringPermutation().permute(input);
    }
}
