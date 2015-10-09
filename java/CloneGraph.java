/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, newHead);
        queue.offer(node);
        while (queue.size() > 0) {
            UndirectedGraphNode curr = queue.poll();
            List<UndirectedGraphNode> currNeighbors = curr.neighbors;
            for (int i = 0; i < currNeighbors.size(); i++) {
                UndirectedGraphNode currCopy = map.get(curr);
                if (map.containsKey(currNeighbors.get(i)) == false) {
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(currNeighbors.get(i).label);
                    currCopy.neighbors.add(neighborCopy);
                    map.put(currNeighbors.get(i), neighborCopy);
                    queue.offer(currNeighbors.get(i));
                } else {
                    currCopy.neighbors.add(map.get(currNeighbors.get(i)));
                }
            }
        }

        return newHead;
    }
}
