package leetcode3;

import datastructure.ListNode;

public class Leetcode206 {
    /*Description
    * 反转一个单链表。
    * */

    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode curNext=result.next.next;
        result.next.next=null;
        while(curNext!=null){
            ListNode next=result.next;
            result.next=curNext;
            curNext=curNext.next;
            result.next.next=next;
        }
        return result.next;
    }
}
