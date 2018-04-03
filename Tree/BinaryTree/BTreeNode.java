package Tree.BinaryTree;

public class BTreeNode {
    private int data;
    private BTreeNode left;
    private BTreeNode right;

    public BTreeNode(int data) {
        this.data = data;
    }

    public BTreeNode() {
    }

    public int getData() {
        return data;
    }

    public BTreeNode setData(int data) {
        this.data = data;
        return this;
    }

    public BTreeNode getLeft() {
        return left;
    }

    public BTreeNode setLeft(BTreeNode left) {
        this.left = left;
        return this;
    }

    public BTreeNode getRight() {
        return right;
    }

    public BTreeNode setRight(BTreeNode right) {
        this.right = right;
        return this;
    }
}
