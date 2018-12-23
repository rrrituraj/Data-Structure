package Tree.BinaryTree;

import java.util.Arrays;

public class PrintAllPathsOfTree {
  private BTreeNode root;

  public PrintAllPathsOfTree() {
    BTreeNode node1 = new BTreeNode(10);
    BTreeNode node2 = new BTreeNode(20);
    BTreeNode node3 = new BTreeNode(30);
    BTreeNode node4 = new BTreeNode(40);
    BTreeNode node5 = new BTreeNode(50);
    BTreeNode node6 = new BTreeNode(60);
    BTreeNode node7 = new BTreeNode(70);
    BTreeNode node8 = new BTreeNode(80);
    BTreeNode node9 = new BTreeNode(90);
    BTreeNode node10 = new BTreeNode(100);
    root = node1;
    node1.setLeft(node2);
    node1.setRight(node3);
    node2.setLeft(node4);
    node2.setRight(node5);
    node3.setLeft(node6);
    node3.setRight(node7);
    node5.setRight(node8);
    node8.setRight(node9);
    node7.setLeft(node10);
  }

  public static void main(String[] args) {
    PrintAllPathsOfTree tree = new PrintAllPathsOfTree();
    tree.printAllPathsToLeaf(tree.root, new int[10], 0);
  }

  public void printAllPathsToLeaf(BTreeNode root, int[] path, int len) {
    if (root == null) return;
    path[len] = root.getData();
    len++;
    if (root.getLeft() == null && root.getRight() == null) {
      Arrays.stream(path).forEach(k -> System.out.print(k+"   "));
      System.out.println();
      return;
    }
    printAllPathsToLeaf(root.getLeft(), path, len);
    printAllPathsToLeaf(root.getRight(), path, len);
  }
}
