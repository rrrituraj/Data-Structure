package string;

import java.util.Arrays;

public class ReverseWords {
  public static void main(String[] args) {
    //    String word = "i.like.this.program.very.much";
    String word = "i.like.this.program.very.much";
    if (reveresedWords(word) != null) {
      System.out.println(Arrays.toString(reveresedWords(word)));
    }
  }

  private static String[] reveresedWords(String word) {
    String[] strArray = word.split(".");
    //    System.out.println(word.split("."));
    return strArray;
  }
}
