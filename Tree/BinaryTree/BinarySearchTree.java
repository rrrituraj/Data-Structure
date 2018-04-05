package Tree.BinaryTree;

public class BinarySearchTree {
  private BTreeNode root;

  public BinarySearchTree() {
    root = null;
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
}
