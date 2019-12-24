/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            Node topNode = queue.poll();
            
            if (!map.containsKey(topNode)) {
                Node copy = new Node(topNode.val, new ArrayList<>());
                map.put(topNode, copy);
            }
            
            Node copy = map.get(topNode);
            List<Node> neighbors = topNode.neighbors;
            
            for (Node n : neighbors) {
                if (!map.containsKey(n)) {
                    Node c = new Node(n.val, new ArrayList<>());
                    map.put(n, c);
                    queue.offer(n);
                }
                
                copy.neighbors.add(map.get(n));
            }
        }
        
        return map.get(node);
    }
}
