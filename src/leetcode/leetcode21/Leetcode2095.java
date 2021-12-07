package leetcode.leetcode21;

import datastructure.ListNode;

public class Leetcode2095 {

    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null)
            return null;

        ListNode fast=head.next;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}
