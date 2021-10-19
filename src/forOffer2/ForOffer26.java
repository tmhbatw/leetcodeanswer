package forOffer2;

import datastructure.ListNode;

public class ForOffer26 {

    public void reorderList(ListNode head) {
        if(head==null)
            return;

        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode next=slow.next;
        slow.next=null;
        next=reverse(next);

        ListNode result=new ListNode(-1);
        ListNode cur=result;
        ListNode h=head;
        while(h!=null||next!=null){
            cur.next=h;
            h=h.next;
            cur=cur.next;
            cur.next=next;
            cur=cur.next;
            if(next==null)
                break;
            next=next.next;
        }
    }

    private ListNode reverse(ListNode cur){
        if(cur==null)
            return null;
        ListNode next=cur.next;
        cur.next=null;
        while(next!=null){
            ListNode temp=next.next;
            next.next=cur;
            cur=next;
            next=temp;
        }
        return cur;
    }
}
