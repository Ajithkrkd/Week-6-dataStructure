public class binaryTree {

    
    private class Node {
        public int value;
        public Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root;

    binaryTree() {
        root = null;
    }
// the insert function  first check the root is null or not if it is null then create a node and insert it
// then make the node as root
    public void insert(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }
// here is root node is there then we have to check wether the value is less than or equal to the curent node
// if it is less than then it is check
        Node currNode = root;
        while (true) {
            if (value < currNode.value) {
                if (currNode.left == null) {
                    currNode.left = node;
                    break;
                } else {
                    currNode = currNode.left;
                }
            } else if (value > currNode.value) {
                if (currNode.right == null) {
                    currNode.right = node;
                    break;
                } else {
                    currNode = currNode.right;
                }
            }

        }
    }

    public boolean contain(int value) {
        Node curNode = root;
        while (curNode != null) {
            if (value < curNode.value) {
                curNode = curNode.left;
            } else if (value > curNode.value) {
                curNode = curNode.right;
            } else {
                return true;
            }
        }
        return false;
    }
    public void postOrderDisplay() {
        postOrderDisplay(root);
    }

    private void postOrderDisplay(Node node) {
        if (node == null) {
            return;
        }
        postOrderDisplay(node.left);
        postOrderDisplay(node.right);
        System.out.print(node.value + " ");
    }

    public void preOrderdiplay(){
        preOrderdiplay( root );
    }

    private void preOrderdiplay(Node node ) {
        if ( node == null){
            return;
        }
        System.out.print(node.value + " ");
        preOrderdiplay(node.left);
        preOrderdiplay(node.right);
        
    }
    public void inOrderDisplay(){
        inOrderDisplay(root);
    }
    
    private void inOrderDisplay(Node node) {
        if(node == null){
            return;
        }
        inOrderDisplay(node.left);
        System.out.print(node.value + " ");
        inOrderDisplay(node.right);
    }
    
    
    //main fuction
    public static void main(String[] args) {
        binaryTree t = new binaryTree();
        t.insert(6);
        t.insert(7);
        t.insert(3);
        t.insert(4);
        t.insert(9);
        
        t.postOrderDisplay();
        
        
        
    }
}
