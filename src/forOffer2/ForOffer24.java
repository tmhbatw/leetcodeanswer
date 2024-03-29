package forOffer2;

import datastructure.ListNode;

public class ForOffer24 {
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
