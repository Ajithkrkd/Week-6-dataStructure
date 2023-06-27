public class TrieImplimantation {
   private TrieNode root;

   public TrieImplimantation() {
      root = new TrieNode(); // root is empty
   }

   // int Trie we want a Node class then we want a array also a bool val for
   // addinge end of word
   static class TrieNode {
      private TrieNode[] children;
      private boolean isWord;

      public TrieNode() {
         this.children = new TrieNode[26]; // words are from a to z
         this.isWord = false;
      }
   }

   // here insert function i pass a argument as String "word"
   // then make a temporary node
   // find the index using letter - 'a';

   public void insert(String word) {

      TrieNode currNode = root;
      for (int i = 0; i < word.length(); i++) {
         char letter = word.charAt(i);
         int index = letter - 'a';

         if (currNode.children[index] == null) {
            TrieNode newNode = new TrieNode();
            currNode.children[index] = newNode;
            currNode = newNode;
         } else {
            currNode = currNode.children[index];
         }
      }
      currNode.isWord = true;
   }

   public boolean contain(String word) {
      TrieNode currNode = root;

      for (int i = 0; i < word.length(); i++) {

         char letter = word.charAt(i);

         int index = letter - 'a';

         if (currNode.children[index] == null) {

            return false;
         }
         currNode = currNode.children[index];
      }
      return currNode.isWord;

   }

   public static void main(String[] args) {
      TrieImplimantation trie = new TrieImplimantation();
      trie.insert("mannan");
      trie.insert("manal");
      trie.insert("mannan");
      System.out.println(trie.contain("manal"));
   }

}
