package forOffer2;

import datastructure.ListNode;

public class ForOffer21 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result=new ListNode(-1);
        result.next=head;
        int size=0;
        ListNode cur=result;
        for(int i=0;i<n;i++)
            cur=cur.next;
        ListNode curr=result;
        while(cur.next!=null){
            cur=cur.next;
            curr=curr.next;
        }
        curr.next=curr.next.next;
        return result.next;
    }
}
