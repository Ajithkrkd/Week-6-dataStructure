package BinarySearchTree;
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

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public boolean isbalanced() {
        return isbalanced(root);
    }

    public boolean isbalanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && isbalanced(node.left) && isbalanced(node.right);
    }

    public void populate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }

    }

    public void inOrderTraversal() {
        inOrderTraversal(root);

    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " ");
            inOrderTraversal(node.right);
        }
    }

    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.value + " ");

        }

    }

    // this function to remove elements

    public void remove(int value) {
        removeHeleper(value, root, null);
    }

    private void removeHeleper(int value, Node currNode, Node parentNode) {
        while (currNode != null) {
            if (value < currNode.value) {
                parentNode = currNode;
                currNode = currNode.left;
            } else if (value > currNode.value) {
                parentNode = currNode;
                currNode = currNode.right;
            } else {
                if (currNode.left != null && currNode.right != null) {
                    currNode.value = getMinValue(currNode.right);
                    removeHeleper(currNode.value, currNode.right, currNode);
                } else {
                    if (parentNode == null) {
                        if (currNode.right == null) {
                            root = currNode.left;
                        } else {
                            root = currNode.right;
                        }
                    }
                    // parent is not null
                    else {
                        // the element is in the left tree of parent node
                        if (parentNode.left == currNode) {
                            if (currNode.right == null) {
                                parentNode.left = currNode.left;
                            } else {
                                parentNode.left = currNode.right;
                            }
                        }
                        // the element is in the right tree of parent node
                        else {
                            if (currNode.right == null) {
                                parentNode.right = currNode.left;
                            } else {
                                parentNode.right = currNode.right;
                            }
                        }
                    }
                }
                break;
            }

        }
    }

    public int getMinValue(Node currNode) {
        if (currNode.left == null) {
            return currNode.value;
        } else {

            return getMinValue(currNode.left);
        }

    }

    // for check if a value is present in the tree
    public boolean contain(int value) {
        Node currNode = root;
        while (currNode != null) {
            if (value < currNode.value) {
                currNode = currNode.left;
            } else if (value > currNode.value) {
                currNode = currNode.right;
            } else {
                return true;
            }
        }
        return false;
    }
}