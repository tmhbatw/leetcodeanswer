package leetcode1;

import datastructure.ListNode;

public class Leetcode19 {
    /*Description
    *给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * */


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode cur=head;
        for(int i=0;i<n-1;i++)
            cur=cur.next;
        ListNode res=result;
        while(cur.next!=null){
            cur=cur.next;
            res=res.next;
        }
        res.next=res.next.next;
        return result.next;
    }
}
