package Tree.BinaryTree;

public class BinaryTreeClient {

  public BinaryTreeClient() {
  }

  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
      Integer[] arr = new Integer[]{3, 6, 8, 2, 11, 13, 9, 5, 7};
      tree.insertLevelOrder(arr);
      //    tree.displayTree();
      //    tree.displayTreeByLevel();
      //    tree.lowestCommonAncestor(13,9);
      // System.out.println(tree.isBST());
      System.out.println(tree.height());
  }
}
