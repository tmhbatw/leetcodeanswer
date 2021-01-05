package leetcode2;

import datastructure.ListNode;

public class Leetcode143 {
    /*Description
    * 给定一个单链表L：L0→L1→…→Ln-1→Ln ，
    * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
    * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    * */
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)
            return ;
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode fast=result,slow=result;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode right=reverse(slow);
        slow=right.next;
        right.next=null;
        ListNode cur=result;
        while(slow!=null){
            cur=cur.next;
            ListNode next=cur.next;
            cur.next=slow;
            slow=slow.next;
            cur=cur.next;
            cur.next=next;
        }
    }

    private ListNode reverse(ListNode cur){
        ListNode curNext=cur.next.next;
        cur.next.next=null;
        while(curNext!=null){
            ListNode next=cur.next;
            cur.next=curNext;
            ListNode curr=curNext;
            curNext=curNext.next;
            curr.next=next;
        }
        return cur;
    }
}
