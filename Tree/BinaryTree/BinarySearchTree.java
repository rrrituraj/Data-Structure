package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import org.jetbrains.annotations.Contract;

@SuppressWarnings("ALL")
public class BinarySearchTree {

  private BTreeNode root;
  private Integer integer;

  public BinarySearchTree() {
    root = null;
  }

  public BTreeNode getRoot() {
    return root;
  }

  public BinarySearchTree setRoot(BTreeNode root) {
    this.root = root;
    return this;
  }

  public void insertData(int data) {
    root = insertData(root, data);
  }

  private BTreeNode insertData(BTreeNode root, int data) {
    if (root == null) {
      root = new BTreeNode();
      root.setData(data);
      return root;
    }
    if (data < root.getData()) {
      root.setLeft(insertData(root.getLeft(), data));
    } else if (data > root.getData()) {
      root.setRight(insertData(root.getRight(), data));
    }
    return root;
  }

  public void deleteData(int data) {
    root = deleteDataNode(root, data);
  }

  private BTreeNode deleteDataNode(BTreeNode root, int data) {
    if (root == null) {
      System.out.println("No Data found");
    } else if (data < root.getData()) {
      root.setLeft(deleteDataNode(root.getLeft(), data));
    } else if (data > root.getData()) {
      root.setRight(deleteDataNode(root.getRight(), data));
    } else {
      if (root.getLeft() != null && root.getRight() != null) {
        BTreeNode temp = findMin(root.getLeft());
        root.setData(temp.getData());
        root.setLeft(deleteDataNode(root.getLeft(), root.getData()));
      } else {
        BTreeNode temp = root;
        if (root.getLeft() == null) {
          root = root.getRight();
        }
        if (root != null && root.getRight() == null) {
          root = root.getLeft();
        }
      }
    }

    return root;
  }

  private BTreeNode findMin(BTreeNode root) {
    if (root == null) {
      return null;
    } else {
      if (root.getLeft() == null) {
        return root;
      } else {
        return findMin(root.getLeft());
      }
    }
  }

  public int sizeOfTree() {
    return sizeOfTree(root);
  }

  private int sizeOfTree(BTreeNode root) {
    if (root == null) {
      return 0;
    }
    return sizeOfTree(root.getLeft()) + sizeOfTree(root.getRight()) + 1;
  }

  public int height() {
    return height(root);
  }

  private int height(BTreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
  }

  /*
  root to leaf sum
   */
  public boolean rootToLeafSum(int sum, ArrayList<Integer> result) {

    return rootToLeafSum(root, sum, result);
  }

  private boolean rootToLeafSum(BTreeNode root, int sum, ArrayList<Integer> result) {
    if (root == null) {
      return false;
    }
    if (root.getLeft() == null && root.getRight() == null) {
      if (root.getData() == sum) {
        result.add(root.getData());
        return true;
      } else {
        return false;
      }
    }
    if (rootToLeafSum(root.getLeft(), sum - root.getData(), result)) {
      result.add(root.getData());
      return true;
    }
    if (rootToLeafSum(root.getRight(), sum - root.getData(), result)) {
      result.add(root.getData());
      return true;
    }
    return false;
  }

  public void displayTree() {
    displayTree(root);
  }

  public void displayTree(BTreeNode root) {
    if (root != null) {
      System.out.print(root.getData() + "  ");
      displayTree(root.getLeft());
      displayTree(root.getRight());
    }
  }

  public boolean isBST() {
    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isBST(BTreeNode root, int minValue, int maxValue) {
    if (root == null) {
      return true;
    }
    if (root.getData() <= minValue || root.getData() >= maxValue) {
      return false;
    }
    return isBST(root.getLeft(), minValue, root.getData())
        && isBST(root.getRight(), root.getData(), maxValue);
  }

  public void levelByTraversal() {
    BTreeNode node = root;
    levelByTraversal(node);
  }

  public void levelorderTraversal() {
    BTreeNode node = root;
    levelorderTraversal(node);
  }

  private void levelorderTraversal(BTreeNode node) {
    if (node == null) {
      return;
    }
    Queue<BTreeNode> q = new LinkedList<>();
    q.add(node);
    while (!q.isEmpty()) {
      node = q.poll();
      System.out.print(node.getData() + "  ");
      if (node.getLeft() != null) {
        q.add(node.getLeft());
      }
      if (node.getRight() != null) {
        q.add(node.getRight());
      }
    }
  }

  private void levelByTraversal(BTreeNode node) {
    if (node == null) {
      return;
    }
    Queue<BTreeNode> q1 = new LinkedList<>();
    Queue<BTreeNode> q2 = new LinkedList<>();
    q1.add(node);
    while (!q1.isEmpty() || !q2.isEmpty()) {
      while (!q1.isEmpty()) {
        node = q1.poll();
        System.out.print(node.getData() + " ");
        if (node.getLeft() != null) {
          q2.add(node.getLeft());
        }
        if (node.getRight() != null) {
          q2.add(node.getRight());
        }
      }
      System.out.println();
      while (!q2.isEmpty()) {
        node = q2.poll();
        System.out.print(node.getData() + " ");
        if (node.getLeft() != null) {
          q1.add(node.getLeft());
        }
        if (node.getRight() != null) {
          q1.add(node.getRight());
        }
      }
      System.out.println();
    }
  }

  public void levelOrderTraversalInReverse() {
    levelOrderTraversalInReverse(root);
  }

  private void levelOrderTraversalInReverse(BTreeNode root) {
    if (root == null) {
      return;
    }
    Queue<BTreeNode> q = new LinkedList<>();
    Stack<BTreeNode> s = new Stack<>();
    q.add(root);
    while (!q.isEmpty()) {
      root = q.poll();

      if (root.getLeft() != null) {
        q.offer(root.getLeft());
      }
      if (root.getRight() != null) {
        q.offer(root.getRight());
      }
      s.push(root);
    }
    while (!s.isEmpty()) {
      System.out.print(s.pop().getData() + "  ");
    }
  }

  public void lowestCommonAncestor(Integer n1, Integer n2) {
    BTreeNode node1 = search(root, n1);
    BTreeNode node2 = search(root, n2);
    BTreeNode lca = LCA(root, node1, node2);
    System.out.println("Lowest Common Ancestor is " + lca.getData());
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

  public void search(Integer data) {
    BTreeNode node = search(root, data);
    System.out.println(node.getData() + "  found!");
  }

  private BTreeNode search(BTreeNode root, Integer data) {
    if (root == null) {
      System.out.println("root is null");
    }
    if (root.getData() == data) {
      return root;
    }
    if (data < root.getData()) {
      return search(root.getLeft(), data);
    } else {
      return search(root.getRight(), data);
    }
  }

  public void lowestCommonAncestorBST(Integer n1, Integer n2) {
    BTreeNode node1 = search(root, n1);
    BTreeNode node2 = search(root, n2);
    BTreeNode lca = BST_LCA(root, node1, node2);
    System.out.println("Lowest Common Ancestor By BST Way is " + lca.getData());
  }

  private BTreeNode BST_LCA(BTreeNode root, BTreeNode node1, BTreeNode node2) {
    if (root == null) {
      return null;
    }
    if (root.getData() > node1.getData() && root.getData() > node2.getData()) {
      return BST_LCA(root.getLeft(), node1, node2);
    }
    if (root.getData() < node1.getData() && root.getData() < node2.getData()) {
      return BST_LCA(root.getRight(), node1, node2);
    } else {
      return root;
    }
  }
}
