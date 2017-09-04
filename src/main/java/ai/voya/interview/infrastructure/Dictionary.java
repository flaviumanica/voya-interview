package ai.voya.interview.infrastructure;

/**
 * Created by ionutradu on 01/09/2017.
 */

// TODO: implement this
    // Hint: look for trie
public class Dictionary {
    private Node root;
    
    public Dictionary() {
        root = new Node();
    }
        
    public Node getRoot() {
        return root;
    }
    
    public void setRoot(Node root) {
        this.root = root;
    }
    
    public void insertWord(String word) {
        Node parent = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (parent.getChildren()[c-'a'] == null) parent.getChildren()[c-'a'] = new Node();
            parent = parent.getChildren()[c-'a'];
        }
        parent.setWord(word);
    }
}

