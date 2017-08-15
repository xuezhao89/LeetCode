/*
��Ŀ��
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

˼·����HashMap�����¾ɽڵ��ӳ���ϵ����Queue����ɽڵ��neighbors��
���ɽڵ�node���ƺ󣬰�node����queue���������node���ھ��Ǹ��������½ڵ�����map��
�����ھ�ʱ���ܻ��ظ����ƣ�ÿ������һ���ɽڵ㣬���½�һ���½ڵ㲢ӳ�䵽map�������һ���ɽڵ���map��û���ֹ���˵���ýڵ�δ�����ƣ����map����������ɽڵ㣬˵����ǰ�Ѵ������������Ѹýڵ�ĸ��ƽڵ���븴�ƺ�ĸ��ڵ���ھ��С�

ע�⣺HashMap������䵱��boolean[] visited��Ҳ����ȥ����
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
        // queue���������ͼnode���ھ�
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node, root);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            // �Ѿɽڵ�cur���ھӽڵ㸴�ƺ���ӵ�cur���ƺ���½ڵ��neighbors��
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                // �ж��Ƿ��������ǰ�ھӽڵ㣬û����˵����û���ɵ�ǰ�ھӽڵ���½ڵ�
                if (!map.containsKey(neighbor)) {
                    // ���Ƴ����ھӽڵ���½ڵ�
                    UndirectedGraphNode n = new UndirectedGraphNode(neighbor.label);
                    // ������ھӺ����ھӵ�ӳ���ϵ
                    map.put(neighbor, n);
                    // �Ѹձ������ľ��ھӽڵ㱣�浽queue��
                    queue.offer(neighbor);
                }
                // �������ɵ��ھӽڵ���ӵ�cur���ƺ�ڵ��neighbors��
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return root;
    }
}