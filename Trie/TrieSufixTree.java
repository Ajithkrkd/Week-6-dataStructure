import java.util.HashMap;
import java.util.Map;

public class TrieSufixTree {

    // here i created a Node class this Node class containing a Map this Map key as
    // charecter and value as a node
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }


    TrieNode root = new TrieNode();
    char endSymbol = '*';
    public TrieSufixTree(){

    }
    public TrieSufixTree (String str){
        populateSufixTree(str);
    }

    private void populateSufixTree(String str){
        for(int i = 0; i < str.length(); i++){
            InsertSubStringStartingAt(i, str);
        }
    }

    private void InsertSubStringStartingAt(int index, String str) {
        TrieNode node = root;

        for(int i = index; i < str.length(); i++){
            char letter = str.charAt(i);
            if(!node.children.containsKey(letter)){
                TrieNode newNode = new TrieNode();
                node.children.put(letter, newNode);
            }
            node = node.children.get(letter);
        }
        node.children.put(endSymbol, null);
    }

    public boolean search(String str){
        TrieNode node = root;

        for(int i = 0; i < str.length(); i++){
            char letter = str.charAt(i);
            if(!node.children.containsKey(letter)){
                return false;
            }
            node = node.children.get(letter);
        }
        return node.children.containsKey(endSymbol);
    }

    public static void main(String[] args) {
        TrieSufixTree trie = new TrieSufixTree();
        trie.populateSufixTree("mannan");
        System.out.println(trie.search("annan"));
    }
}
