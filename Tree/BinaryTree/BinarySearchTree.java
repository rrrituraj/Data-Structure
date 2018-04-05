package Tree.BinaryTree;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class BinarySearchTree {
    private BTreeNode root;

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
        if (root == null) return 0;
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    /*
    root to leaf sum
     */
    public boolean rootToLeafSum(int sum, ArrayList<Integer> result) {

        return rootToLeafSum(root, sum, result);
    }

    private boolean rootToLeafSum(BTreeNode root, int sum, ArrayList<Integer> result) {
        if (root == null) return false;
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
        if (root == null) return true;
        if (root.getData() <= minValue || root.getData() >= maxValue) return false;
        return isBST(root.getLeft(), minValue, root.getData())
                && isBST(root.getRight(), root.getData(), maxValue);
    }
}
