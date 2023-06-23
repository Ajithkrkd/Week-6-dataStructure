public class BinarySearchTree {

    private class Node {
        public int value;
        public Node left;
        public Node right;
        public int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    BinarySearchTree() {
        root = null;
    }

    // for finding the height of the node
    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    // this function for checking this tree is empty or not
    public boolean isEmpty() {
        return root == null;
    }

    public void display() {
        if (root == null) {
            System.out.println("Empty tree");
        } else {
            display(root, "Root Node: ");
        }
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.getValue());
        display(node.left, "The left child of " + node.getValue() + ":");
        display(node.right, "The right child of " + node.getValue() + ":");
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        } else if (value > node.value) {
            node.right = insert(value, node.right);
        }

        return node;
    }
}