class TrieNode {
    char val;
    Map<Character, TrieNode> dict;
    boolean isLeaf;
    
    TrieNode(char v, boolean b) {
        this.val = v;
        this.isLeaf = b;
        this.dict = new HashMap<>();
    }
}

class Trie {
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode('\0', true);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (!curr.dict.containsKey(currChar)) {
                curr.dict.put(currChar, new TrieNode(currChar, false));
            }
            
            curr = curr.dict.get(currChar);
            if (i == word.length() - 1) {
                curr.isLeaf = true;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (!curr.dict.containsKey(currChar)) {
                return false;
            }
            
            curr = curr.dict.get(currChar);
        }
        
        return curr.isLeaf;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currChar = prefix.charAt(i);
            if (!curr.dict.containsKey(currChar)) {
                return false;
            }
            
            curr = curr.dict.get(currChar);
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
