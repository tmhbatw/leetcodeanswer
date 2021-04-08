package leetcode.leetcode1;

import datastructure.ListNode;

public class Leetcode82 {
    /*Description
    * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     * */

    public ListNode deleteDuplicates(ListNode head) {
        ListNode result=new ListNode(-1);
        ListNode cur=result;
        while(head!=null){
            int curVal=head.val;
            if(head.next==null||head.next.val!=curVal){
                cur.next=head;
                cur=cur.next;
            }else{
                while(head.next!=null&&head.next.val==curVal)
                    head=head.next;
            }
            head=head.next;
        }
        cur.next=null;
        return result.next;
    }
}
