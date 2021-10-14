package leetcode.leetcode9;

import datastructure.ListNode;

import java.util.List;

public class Leetcode876 {

    public ListNode middleNode(ListNode head) {
        ListNode fast=head,slow=head;
        while(fast.next!=null){
            fast=fast.next;
            if(fast.next==null)
                return slow.next;
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
