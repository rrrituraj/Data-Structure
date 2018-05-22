package Tree.BinaryTree;

public class BSTreeClient {
    @SuppressWarnings("unchecked")
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
        //        tree.displayTree();
        //        System.out.println();
    /*System.out.println("\nafter delete");

    tree.deleteData(20);*/

    /*System.out.println("\nSize of tree is:\t" + tree.sizeOfTree());
    System.out.println("\nheight of tree is:\t" + tree.height());*/
    /*ArrayList<Integer> result = new ArrayList();
    System.out.println("\nroot to leaf sum:\t" + tree.rootToLeafSum(120, result));
    for (int i = result.size() - 1; i >= 0; i--) {
        System.out.print("  " + result.get(i));
    }*/
        //        System.out.println("\nisBST:\t" + tree.isBST());
    /*tree.levelByTraversal();
    System.out.println();*/

    /*tree.levelorderTraversal();
    System.out.println();
    tree.levelOrderTraversalInReverse();*/
        //      tree.search(70);
        // System.out.println();

        tree.lowestCommonAncestorBST(20, 40);
    }
}
