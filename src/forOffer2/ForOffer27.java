package forOffer2;

import datastructure.ListNode;

public class ForOffer27 {

    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode reverse=reverseList(slow);
        while(head!=null&&reverse!=null){
            if(head.val!=reverse.val)
                return false;
            head=head.next;
            reverse= reverse.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        ListNode next=head.next;
        head.next=null;
        while(next!=null){
            ListNode temp=next.next;
            next.next=head;
            head=next;
            next=temp;
        }
        return head;
    }
}
