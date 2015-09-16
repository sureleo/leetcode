class TrieNode {
    private char val;
    public Map<Character, TrieNode> dict;
    public boolean isLeaf;

    public TrieNode(char val) {
        this.val = val;
        dict = new HashMap<Character, TrieNode>();
        isLeaf = false;
    }
}

public class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode('\0');
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchTrie(root, word);
    }

    public boolean searchTrie(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isLeaf;
        }

        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (currChar != '.') {
                if (root.dict.containsKey(currChar) == false) {
                    return false;
                } else {
                    return searchTrie(root.dict.get(currChar), word.substring(i+1, word.length()));
                }
            } else {
                boolean result = false;
                for (Map.Entry<Character, TrieNode> entry : root.dict.entrySet()) {
                    result |= searchTrie(entry.getValue(), word.substring(i+1, word.length()));
                }

                return result;
            }
        }

        return false;
    }
}
