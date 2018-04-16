package Tree.BinaryTree;

public class BTreeNode {

  private Integer data;
  private BTreeNode left;
  private BTreeNode right;

  public BTreeNode(int data) {
    this.data = data;
  }

  public BTreeNode() {
  }

  public Integer getData() {
        return data;
    }

  public BTreeNode setData(Integer data) {
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

  @Override
  public String toString() {
    return "BTreeNode{" + "data=" + data + ", left=" + left + ", right=" + right + '}';
  }
}
