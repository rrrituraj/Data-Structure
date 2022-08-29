package string;

import java.util.HashMap;
import java.util.Map;

public class RepeatedSubsequence {
    public static void main(String[] args) {
        String str = "XYBYAXB";
        if (hasRepeatedSubsequence(str)) {
            System.out.println("Repeated subsequence is present");
        }
        else {
            System.out.println("No repeated subsequence is present");
        }
    }

    // Function to checks if repeated subsequence is present in the string
    public static boolean hasRepeatedSubsequence(String str) {
        if (str == null) {
            return false;
        }
        // map to store the frequency of each distinct character
        // of a given string
        Map<Character, Integer> frequency = new HashMap<>();
        for (Character c : str.toCharArray()) {
            // update map with frequency
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
            // if the frequency of any character becomes 3,
            // we have found the repeated subsequence
            if (frequency.get(c) >= 3) {
                return true; //repeated subsequence found
            }
        }
        StringBuilder sb = new StringBuilder();
        // consider all repeated elements (frequency 2 or more)
        // and discard all non-repeating elements (frequency 1)
        for (Character c : str.toCharArray()) {
            if (frequency.get(c) >= 2) {
                sb.append(c);
            }
        }
        System.out.println(sb);
        // return false if `sb` is a palindrome
        return !RotationPalindrome.isPallindrome(sb.toString(), 0, sb.length() - 1);
    }
}
