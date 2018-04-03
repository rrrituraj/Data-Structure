package Tree.BinaryTree;

public class BSTreeClient {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertData(1);
        binarySearchTree.insertData(2);
        binarySearchTree.insertData(3);
        binarySearchTree.insertData(5);
        binarySearchTree.insertData(4);
        binarySearchTree.insertData(6);

        binarySearchTree.displayTree();
    }
}
