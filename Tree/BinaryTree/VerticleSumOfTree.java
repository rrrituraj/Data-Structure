package Tree.BinaryTree;

import java.util.Map;
import java.util.TreeMap;

public class VerticleSumOfTree {
  private BTreeNode root;

  public VerticleSumOfTree() {
    BTreeNode node1 = new BTreeNode(10);
    BTreeNode node2 = new BTreeNode(10);
    BTreeNode node3 = new BTreeNode(10);
    BTreeNode node4 = new BTreeNode(10);
    BTreeNode node5 = new BTreeNode(10);
    BTreeNode node6 = new BTreeNode(10);
    BTreeNode node7 = new BTreeNode(10);
    BTreeNode node8 = new BTreeNode(10);
    BTreeNode node9 = new BTreeNode(10);
    BTreeNode node10 = new BTreeNode(10);
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
    VerticleSumOfTree tree = new VerticleSumOfTree();
    Map<Integer, Integer> treemap = new TreeMap<>();
    tree.printVerticleSumOfBinaryTree(tree.root, treemap, 0);
    System.out.println(treemap.toString());
  }

  public void printVerticleSumOfBinaryTree(
      BTreeNode root, Map<Integer, Integer> treeMap, int level) {
    if (root == null) {
      return;
    }
    printVerticleSumOfBinaryTree(root.getLeft(), treeMap, level - 1);
    treeMap.merge(level, root.getData(), (a, b) -> a + b);
    printVerticleSumOfBinaryTree(root.getRight(), treeMap, level + 1);
  }
}
