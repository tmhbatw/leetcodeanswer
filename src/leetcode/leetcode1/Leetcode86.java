package leetcode.leetcode1;

import datastructure.ListNode;

public class Leetcode86 {
    /*Description
    * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
    * 你应当保留两个分区中每个节点的初始相对位置。
    * */

    public ListNode partition(ListNode head, int x) {
        ListNode left=new ListNode(0);
        ListNode curLeft=left;
        ListNode right=new ListNode(0);
        ListNode curRight=right;
        while(head!=null){
            int val=head.val;
            if(val<x){
                curLeft.next=new ListNode(val);
                curLeft=curLeft.next;
            }else{
                curRight.next=new ListNode(val);
                curRight=curRight.next;
            }
            head=head.next;
        }
        curLeft.next=right.next;
        return left.next;
    }
}
