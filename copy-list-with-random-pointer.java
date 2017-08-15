/*
题目：
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.

思路：
建新链表，在原链表遍历每一个原节点，复制原链表每个节点的值到新建节点里；
把新节点一一插在原链表每个节点的后面，从而原链表每个节点的next关系在新链表得以实现；
建哈希表记录原节点和复制节点的对应关系；
再次遍历原链表每一个原节点，在哈希表里找原节点对应的random节点，在新链表里连接random关系

注意：记得连接random关系前要把cur指针回归到head。
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode dummyCur = dummy;
        RandomListNode cur = head;
        
        while (cur != null) {
            RandomListNode n = new RandomListNode(cur.label);
            dummyCur.next = n;
            map.put(cur, n);
            cur = cur.next;
            dummyCur = dummyCur.next;
        }
        
        cur = head;
        RandomListNode copiedNode = map.get(cur);
        while (cur != null) {
            copiedNode.random = map.get(cur.random);
            cur = cur.next;
            copiedNode = copiedNode.next;
        }
        
        return dummy.next;
    }
}
