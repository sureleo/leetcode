class TrieNode {
    private char val;
    public Map<Character, TrieNode> dict;
    public boolean isLeaf;
    
    public TrieNode (char val) {
        this.val = val;
        this.dict = new HashMap<Character, TrieNode>();
        this.isLeaf = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (curr.dict.containsKey(currChar) == false) {
                TrieNode next = new TrieNode(currChar);
                curr.dict.put(currChar, next);
                curr = next;
            } else {
                TrieNode next = curr.dict.get(currChar);
                curr = next;
            }
            
            if (i == word.length() - 1) {
                curr.isLeaf = true;
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (curr.dict.containsKey(currChar) == false) {
                return false;
            } else {
                curr = curr.dict.get(currChar);
            }
        }
        
        return curr.isLeaf;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currChar = prefix.charAt(i);
            if (curr.dict.containsKey(currChar) == false) {
                return false;
            } else {
                curr = curr.dict.get(currChar);
            }
        }
        
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
