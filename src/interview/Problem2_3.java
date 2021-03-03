package interview;

import datastructure.ListNode;

public class Problem2_3 {
    /*Description
    * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
     * */

    public void deleteNode(ListNode node) {
        ListNode result=node;
        while(node.next!=null){
            node.val=node.next.val;
            if(node.next.next==null) {
                node.next = null;
                return;
            }
            node=node.next;
        }
    }
}
