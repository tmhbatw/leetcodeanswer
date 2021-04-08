package leetcode.leetcode1;

import datastructure.ListNode;

public class Leetcode25 {
    /*Description
    * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。k是一个正整数，它的值小于或等于链表的长度。
    * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
    * 示例：给你这个链表：1->2->3->4->5
    * 当k= 2 时，应当返回: 2->1->4->3->5
    * 当k= 3 时，应当返回: 3->2->1->4->5
    * 说明：你的算法只能使用常数的额外空间。
    * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
    * */

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode cur=result;
        ListNode last=exist(cur,k);
        while(last!=null){
            ListNode tail=cur.next;
            ListNode tailNext=last.next;
            ListNode curLeft=cur.next.next;
            for(int i=0;i<k-1;i++){
                ListNode next=cur.next;
                cur.next=curLeft;
                curLeft=curLeft.next;
                cur.next.next=next;
            }
            cur=tail;
            cur.next=tailNext;
            last=exist(cur,k);
        }
        return result.next;
    }

    private ListNode exist(ListNode cur,int k){
        while(k-->0){
            cur=cur.next;
            if(cur==null)
                return null;
        }
        return cur;
    }
}
