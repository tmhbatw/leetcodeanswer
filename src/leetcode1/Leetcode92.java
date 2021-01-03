package leetcode1;

import datastructure.ListNode;

public class Leetcode92 {
    /*Description
    * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
    * */

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
            return head;
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode cur=result;
        n-=m;
        while(--m>0){
            cur=cur.next;
        }
        ListNode first=cur.next;
        ListNode post=cur.next.next;
        while(n-->0){
            ListNode next=cur.next;
            cur.next=post;
            post=cur.next.next;
            cur.next.next=next;
        }
        first.next=post;
        return result.next;
    }
}
