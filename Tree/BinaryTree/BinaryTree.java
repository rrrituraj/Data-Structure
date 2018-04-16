package Tree.BinaryTree;

import org.jetbrains.annotations.Contract;

public class BinaryTree {

  private BTreeNode root;

  public BinaryTree() {
  }

  public void insertLevelOrder(Integer[] arr) {
    root = insertLevelOrder(arr, root, 0);
  }

  public BTreeNode insertLevelOrder(Integer[] arr, BTreeNode root, Integer i) {
    if (i < arr.length) {
      root = new BTreeNode(arr[i]);
      root.setLeft(insertLevelOrder(arr, root.getLeft(), 2 * i + 1));
      root.setRight(insertLevelOrder(arr, root.getRight(), 2 * i + 2));
    }
    return root;
  }

  public void lowestCommonAncestor(Integer n1, Integer n2) {
    //    BinarySearchTree binarySearchTree=new BinarySearchTree();
    BTreeNode node1 = search(root, n1);
    BTreeNode node2 = search(root, n2);
    BTreeNode lca = LCA(root, node1, node2);
    System.out.println("Lowest Common Ancestor is " + lca.getData());
  }

  private BTreeNode search(BTreeNode root, Integer data) {
    if (root == null) {
      return null;
    } else {
      if (data.equals(root.getData())) {
        return root;
      } else {
        BTreeNode temp = search(root.getLeft(), data);
        if (temp != null && data.equals(temp.getData())) {
          return temp;
        } else {
          return search(root.getRight(), data);
        }
      }
    }
  }

  @Contract("null, _, _ -> null")
  private BTreeNode LCA(BTreeNode root, BTreeNode node1, BTreeNode node2) {

    if (root == null) {
      return null;
    }
    if (root == node1 || root == node2) {
      return root;
    }
    BTreeNode left = LCA(root.getLeft(), node1, node2);
    BTreeNode right = LCA(root.getRight(), node1, node2);
    if (left != null && right != null) {
      return root;
    }
    if (left == null && right == null) {
      return null;
    }
    return left != null ? left : right;
  }

  public boolean isBST() {
    BinarySearchTree bst = new BinarySearchTree();
    return bst.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public void displayTree() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.levelorderTraversal(root);
  }

  public void displayTreeByLevel() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.levelByTraversal(root);
  }
}
