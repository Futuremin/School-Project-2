import trees.preorder.LinkedBinaryTree;
import trees.preorder.Position;

public class Main {
    public static void main(String[] args) {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        Position<String> root = tree.addRoot("A");
        Position<String> b = tree.addLeft(root, "B");
        Position<String> c = tree.addRight(root, "C");
        tree.addLeft(b, "D");
        tree.addRight(b, "E");
        tree.addRight(c, "F");

        System.out.println("Next after B: " + tree.preorderNextElement("B")); // Should print D
        System.out.println("Next after E: " + tree.preorderNextElement("E")); // Should print C
        System.out.println("Next after F: " + tree.preorderNextElement("F")); // Should print null
    }
}
