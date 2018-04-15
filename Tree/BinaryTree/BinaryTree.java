package Tree.BinaryTree;

public class BinaryTree {

  private BTreeNode root;

  public BinaryTree() {
    root = insert();
  }

  private BTreeNode insert() {
    root.setData(1);
    root.setLeft(new BTreeNode(2));
    root.setRight(new BTreeNode(3));
    root.getLeft().setLeft(new BTreeNode(4));
    root.getLeft().setRight(new BTreeNode(5));
    root.getRight().setLeft(new BTreeNode(6));
    root.getRight().setRight(new BTreeNode(7));
    return root;
  }

  public void LCA(Integer n1, Integer n2) {
//  	BTreeNode node1=
  }

  public void LCA() {

  }
}
