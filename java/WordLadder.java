class Node {
    String word;
    int steps;
    
    Node(String w, int s) {
        this.word = w;
        this.steps = s;
    }
}

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);
        Queue<Node> queue = new LinkedList<Node>();
        Node begin = new Node(beginWord, 1);
        queue.offer(begin);
        while (queue.size() > 0) {
            Node node = queue.poll();
            String currWord = node.word;
            if (currWord.equals(endWord)) {
                return node.steps;
            }
            
            char[] curr = currWord.toCharArray();
            for (int i = 0; i < curr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = curr[i];
                    if (curr[i] == c) {
                        continue;
                    } else {
                        curr[i] = c;
                    }
                    
                    String next = new String(curr);
                    if (wordList.contains(next)) {
                        queue.offer(new Node(next, node.steps + 1));
                        wordList.remove(next);
                    }
                    
                    curr[i] = temp;
                }
            }
        }
        
        return 0;
    }
}
