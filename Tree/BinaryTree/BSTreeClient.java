package Tree.BinaryTree;

public class BSTreeClient {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertData(50);
        tree.insertData(30);
        tree.insertData(20);
        tree.insertData(40);
        tree.insertData(70);
        tree.insertData(60);
        tree.insertData(80);

        // print inorder traversal of the BST
        tree.displayTree();
    }
}
