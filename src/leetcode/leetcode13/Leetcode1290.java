package leetcode.leetcode13;

import datastructure.ListNode;

public class Leetcode1290 {
    public int getDecimalValue(ListNode head) {
        int count=0;
        while(head!=null) {
            count = count * 2 + head.val;
            head=head.next;
        }
        return count;
    }
}
