package leetcode.leetcode1;

import datastructure.ListNode;

public class Leetcode83 {
    /*Description
    * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
    * */

    public ListNode deleteDuplicates(ListNode head) {
        ListNode result=new ListNode(-1);
        ListNode curNode=result;
        int cur=Integer.MAX_VALUE;
        while(head!=null){
            if(cur!=head.val){
                curNode.next=head;
                cur=head.val;
                curNode=curNode.next;
            }
            head=head.next;
        }
        curNode.next=null;
        return result.next;
    }
}
