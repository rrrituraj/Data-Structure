//package string;
//
////import com.sun.istack.internal.NotNull;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.logging.Logger;
//
//public class Anagram {
//  private static Logger logger = Logger.getLogger("Anagram.class");
//  String name;
//
//  public static boolean isAnagram(@NotNull String word, @NotNull String angrm) {
//    /*
//     * if length of both string does not match then obviously both are different
//     */
//    if (word.length() != angrm.length()) return false;
//    for (int i = 0; i < word.length(); i++) {
//      char c = Character.toLowerCase(word.charAt(i));
//      int index =
//          angrm.indexOf(c) != -1 ? angrm.indexOf(c) : angrm.indexOf(Character.toUpperCase(c));
//      if (index != -1) {
//        // if character in 'word' found in 'angrm' remove that character from 'angrm'
//        angrm = angrm.substring(0, index) + angrm.substring(index + 1, angrm.length());
//      } else return false;
//    }
//    /* if all character from 'word' is found in 'angrm'
//     * and even after removing those character from 'angrm'
//     * anagram is not empty then there might be some character
//     * which are not in 'word' so return false in that case */
//    return angrm.isEmpty();
//  }
//}
