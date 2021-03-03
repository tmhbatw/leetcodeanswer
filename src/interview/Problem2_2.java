package interview;

import datastructure.ListNode;

public class Problem2_2 {
    /*Description
    * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值
     * */

    public int kthToLast(ListNode head, int k) {
        ListNode first=head;
        while(k-->0){
            first=first.next;
        }
        while(first!=null){
            first=first.next;
            head=head.next;
        }
        return head.val;
    }
}
