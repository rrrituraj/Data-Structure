package string;

public class LongestPalindromeSubstring {
    private static String resStr = "";
    private static int resLength = 0;

    public static void main(String[] args) {
        longestPalindromSubString("babad");
        System.out.println("LPS is: " + resStr);

    }

    public static void longestPalindromSubString(String str) {
        for (int i = 0; i < str.length(); i++) {
            expand(str, i, i);
            expand(str, i, i + 1);
        }
    }

    public static void expand(String str, int low, int high) {
        while (low >= 0 && high < str.length() && (str.charAt(low) == str.charAt(high))) {
            if (high - low + 1 >= resLength) {
                resStr = str.substring(low, high + 1);
                resLength = high - low + 1;
//                System.out.println("LPS is: " + resStr);
            }
            low--;
            high++;
        }
    }
}
