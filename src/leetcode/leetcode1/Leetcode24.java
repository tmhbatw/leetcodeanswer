package leetcode.leetcode1;

import datastructure.ListNode;

public class Leetcode24 {
    /*Description
    *给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    * */

    public ListNode swapPairs(ListNode head) {
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode cur=result;
        while(cur.next!=null&&cur.next.next!=null){
            ListNode next=cur.next;
            cur.next=cur.next.next;
            cur=cur.next;
            next.next=cur.next;
            cur.next=next;
            cur=cur.next;
        }
        return result.next;
    }
}
