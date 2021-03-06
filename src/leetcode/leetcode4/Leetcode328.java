package leetcode.leetcode4;

import datastructure.ListNode;

public class Leetcode328 {
    /*Description
    * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
    * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
    * */

    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode first=head;
        ListNode second=head.next;
        ListNode cur=second.next;
        ListNode curr=second;
        while(cur!=null){
            first.next=cur;
            second.next=cur.next;
            first=first.next;
            second=second.next;
            if(second==null)
                break;
            cur=second.next;
        }
        first.next=curr;
        return head;
    }
}
