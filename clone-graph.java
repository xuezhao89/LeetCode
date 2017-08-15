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
        // queue用来保存旧图node的邻居
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node, root);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            // 把旧节点cur的邻居节点复制后，添加到cur复制后的新节点的neighbors里
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                // 判断是否遍历过当前邻居节点，没有则说明还没生成当前邻居节点的新节点
                if (!map.containsKey(neighbor)) {
                    // 复制出该邻居节点的新节点
                    UndirectedGraphNode n = new UndirectedGraphNode(neighbor.label);
                    // 保存旧邻居和新邻居的映射关系
                    map.put(neighbor, n);
                    // 把刚被遍历的旧邻居节点保存到queue里
                    queue.offer(neighbor);
                }
                // 把新生成的邻居节点添加到cur复制后节点的neighbors里
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return root;
    }
}