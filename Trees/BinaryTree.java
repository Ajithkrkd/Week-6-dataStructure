   
import java.util.Scanner;

public class BinaryTree {
    public BinaryTree() {

    }

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;

        }
    }

    private Node root;

    // INSERT ELEMENT

    public void poppulate(Scanner scanner) {
        System.out.println("Enter The root Node value : ");
        int data = scanner.nextInt();
        root = new Node(data);
        poppulate(scanner, root);
    }

    private void poppulate(Scanner scanner, Node node) {
        System.out.println("do you want to insert element into the left of the Node : " + node.data);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the Value you want to insert left of  : " + node.data);
            int value = scanner.nextInt();
            node.left = new Node(value);
            poppulate(scanner, node.left);
        }

        System.out.println("do you want to insert element into the right of the Node : " + node.data);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the Value you want to insert right of  : " + node.data);
            int value = scanner.nextInt();
            node.right = new Node(value);
            poppulate(scanner, node.right);
        }
    }

    public void prettyDisplay() {
        display(root, 0);
    }

    public void display(Node node, int level) {
        if (node == null) {
            return;
        }
        display(node.right, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|-------->" + node.data);
        }
        // if level is zero that is the root element
        else {
            System.out.println(node.data);
        }
        display(node.left, level + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        tree.poppulate(scanner);
        tree.prettyDisplay();
    }

}
