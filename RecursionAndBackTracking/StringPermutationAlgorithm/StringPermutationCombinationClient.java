package RecursionAndBackTracking.StringPermutationAlgorithm;

public class StringPermutationCombinationClient {
    public static void main(String[] args) {
        char input[] = new char[]{'A', 'A', 'B', 'C'};
        System.out.println("...........permutation....................");
        new StringPermutationCombination().permute(input);
        System.out.println("...........combination....................");
        new StringPermutationCombination().combination(input);
    }
}
