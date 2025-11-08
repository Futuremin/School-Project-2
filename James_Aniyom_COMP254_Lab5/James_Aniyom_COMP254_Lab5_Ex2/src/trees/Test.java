package trees;

public class Test {
    public static void main(String[] args) {
        // Creating a new LinkedBinaryTree of Strings
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();

        // Building the tree structure
        Position<String> root = tree.addRoot("A");
        Position<String> nodeB = tree.addLeft(root, "B");
        Position<String> nodeC = tree.addRight(root, "C");
        Position<String> nodeD = tree.addLeft(nodeB, "D");
        Position<String> nodeE = tree.addRight(nodeB, "E");
        Position<String> nodeF = tree.addLeft(nodeC, "F");

        // Testing printPositionAndHeight()
        System.out.println("Printing element and subtree height for each node:");
        tree.printPositionAndHeight();
    }
}

