import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public void dfs(Node node, HashMap<Node, Node> map) {
        for (Node n: node.neighbors) {
            if (!map.containsKey(n)) map.put(n, new Node(n.val));
            map.get(node).neighbors.add(map.get(n));
        }
        for (Node n: node.neighbors) {
            if (map.get(n).neighbors.size() == 0) dfs(n, map);
        }
    }

    public Node cloneGraph(Node node) {
        HashMap<Node, Node> map = new HashMap<>();
        if (node != null) {
            map.put(node, new Node(node.val));
            dfs(node, map);
            return map.get(node);
        }
        return null;
    }
}