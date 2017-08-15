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