/*
题目：
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
OJ's undirected graph serialization:
Nodes are labeled uniquely.
We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.
The graph has a total of three nodes, and therefore contains three parts as separated by #.
First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/

思路：建HashMap保存新旧节点的映射关系，建Queue保存旧节点的neighbors；
将旧节点node复制后，把node放入queue里；接下来把node的邻居们复制生成新节点后存入map。
复制邻居时可能会重复复制，每遍历过一个旧节点，就新建一个新节点并映射到map里；当发现一个旧节点在map里没出现过，说明该节点未被复制；如果map里已有这个旧节点，说明此前已处理过，但仍需把该节点的复制节点放入复制后的父节点的邻居中。

注意：HashMap在这里充当了boolean[] visited，也可以去环。
*/

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
