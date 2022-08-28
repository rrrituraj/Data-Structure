package string;

public class RotationPalindrome {
    public static void main(String[] args) {
        String str = "CBAABCD";
        System.out.println("isRotationPallindrome: "+isRotationPallindrome(str));
        System.out.println("longestPalindromicSubString: " + longestPalindromicSubString(str + str, str.length()));
    }

    public static boolean isRotationPallindrome(String str) {
        if (str == null) return false;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            str = str.substring(1) + str.charAt(0);
            if (isPallindrome(str, 0, length - 1)) {
                System.out.println("pallindrom String is: " + str);
                return true;
            }
        }
        return false;
    }

    public static boolean isPallindrome(String str, int low, int high) {
        return (low >= high) || (str.charAt(low) == str.charAt(high)) && isPallindrome(str, low + 1, high - 1);

    }

    public static boolean longestPalindromicSubString(String str, int k) {
        for (int i = 0; i < str.length(); i++) {
            if (expand(str, i, i, k) || expand(str, i, i + 1, k)) {
                return true;
            }
        }
        return false;
    }

    private static boolean expand(String str, int low, int high, int k) {
        while (low >= 0 && high < str.length() && (str.charAt(low) == str.charAt(high))) {
            if (high - low + 1 == k) {
                System.out.println("Pallindrom String with LSP is: " + str.substring(low, high+1));
                return true;
            }
            low--;
            high++;
        }
        return false;
    }
}
