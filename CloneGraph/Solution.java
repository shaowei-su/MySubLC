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

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, new UndirectedGraphNode(node.label));
        ArrayList<UndirectedGraphNode> temp = new ArrayList<UndirectedGraphNode>();
        temp.add(node);
        int start = 0;
        while (start < temp.size()) {
        	UndirectedGraphNode crtNode = temp.get(start++);

        	for (UndirectedGraphNode oneNode: crtNode.neighbors) {
		        if (!map.containsKey(oneNode)) {
		        	map.put(oneNode, new UndirectedGraphNode(oneNode.label));
		        	temp.add(oneNode);
		        }
        	}
        }

        for (UndirectedGraphNode crtNode: temp) {
        	UndirectedGraphNode newNode = map.get(crtNode);
        	for (UndirectedGraphNode oneNode: crtNode.neighbors) {
        		newNode.neighbors.add(map.get(oneNode));
        	}

        }

        return map.get(node);
    }
}