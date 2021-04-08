package leetcode.leetcode2;

import datastructure.ListNode;

public class Leetcode148 {
    /*Description
    * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
    * 进阶：
    * 你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
    * */

    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode result=new ListNode(0);
        ListNode fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode right=slow.next;
        slow.next=null;
        ListNode cur=result;
        head=sortList(head);right=sortList(right);
        while(head!=null&&right!=null){
            int headVal=head.val,rightVal=right.val;
            if(headVal<rightVal){
                cur.next=head;
                head=head.next;
            }else{
                cur.next=right;
                right=right.next;
            }
            cur=cur.next;
            cur.next=null;
        }
        if(head!=null)
            cur.next=head;
        else
            cur.next=right;
        return result.next;
    }

}
