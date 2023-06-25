package BinarySearchTree;
public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] arr = new int[] {10,8,11,4,7};
        
        
        tree.populate(arr);
      
        // tree.inOrderTraversal();
        // System.out.println();
        tree.postOrderTraversal();
        // System.out.println();
        // tree.preOrderTraversal();
        // System.out.println();
   
        

    }
}
