package leetcode.leetcode1;

import datastructure.ListNode;

public class Leetcode61 {
    /*Description
    * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
    * */

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        int listNodeLength=getListNodeLength(head);
        k%=listNodeLength;
        if(k==0)
            return head;
        listNodeLength-=k;
        ListNode result=head;
        while(--listNodeLength>0)
            result=result.next;
        ListNode next=result.next;
        result.next=null;
        result=next;
        while(result.next!=null)
            result=result.next;
        result.next=head;
        return next;
    }

    private int getListNodeLength(ListNode cur){
        int result=0;
        while(cur!=null){
            result++;
            cur=cur.next;
        }
        return result;
    }
}
