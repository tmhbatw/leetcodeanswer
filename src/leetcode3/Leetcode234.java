package leetcode3;

import datastructure.ListNode;
import datastructure.TreeNode;

public class Leetcode234 {
    /*Description
    * 请判断一个链表是否为回文链表。
    * */

    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null)
            return true;
        ListNode fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        reverse(slow);
        slow=slow.next;
        while(slow!=null){
            if(head.val!=slow.val){
                return false;
            }
            slow=slow.next;
            head=head.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        if(head.next==null||head.next.next==null)
            return head;
        ListNode curNext=head.next.next;
        head.next.next=null;
        while(curNext!=null){
            ListNode next=head.next;
            head.next=curNext;
            curNext=curNext.next;
            head.next.next=next;
        }
        return head;
    }
}
