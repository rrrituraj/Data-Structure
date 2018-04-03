package Tree.BinaryTree;

public class BinarySearchTree {
    private BTreeNode root;

    public BinarySearchTree() {
    }

    public BTreeNode getRoot() {
        return root;
    }

    public void insertData(int data) {
        insertData(root, data);
    }

    private BTreeNode insertData(BTreeNode root, int data) {
        if (root == null) {
            root = new BTreeNode();
            root.setData(data);
            root.setRight(null);
            root.setLeft(null);
        } else {
            if (data < root.getData()) {
                root.setLeft(insertData(root.getLeft(), data));
            } else if (data > root.getData()) {
                root.setRight(insertData(root.getRight(), data));
            }
        }
        return root;
    }

    public void displayTree() {
        displayTree(root);
    }

    public void displayTree(BTreeNode root) {
        if (root != null) {
            System.out.println(root.getData() + "  ");
            displayTree(root.getLeft());
            displayTree(root.getRight());
        }
    }
}
