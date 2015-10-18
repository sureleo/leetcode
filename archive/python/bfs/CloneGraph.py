# Definition for a undirected graph node
class UndirectedGraphNode:
    def __init__(self, x):
        self.label = x
        self.neighbors = []

class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    def cloneGraph(self, node):
        if node is None:
            return 
        
        d = {}
        queue = [node]
        new_node = UndirectedGraphNode(node.label)
        d[node] = new_node
        while len(queue) > 0:
            curr = queue.pop(0)
            for i in xrange(len(curr.neighbors)):
                if curr.neighbors[i] not in d:
                    copy = UndirectedGraphNode(curr.neighbors[i].label)
                    d[curr].neighbors.append(copy)
                    d[curr.neighbors[i]] = copy
                    queue.append(curr.neighbors[i])
                else:
                    d[curr].neighbors.append(d[curr.neighbors[i]])
        
        return new_node

