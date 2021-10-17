package forOffer2;

import datastructure.ListNode;

public class ForOffer23 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur=headA;
        int length1=0;
        while(cur!=null){
            length1++;
            cur=cur.next;
        }
        int length2=0;
        cur=headB;
        while(cur!=null){
            length2++;
            cur=cur.next;
        }
        if(length1<length2){
            ListNode temp=headA;
            headA=headB;
            headB=temp;
            int length=length1;
            length1=length2;
            length2=length;
        }
        ListNode cur1=headA;
        ListNode cur2=headB;
        for(int i=0;i<length1-length2;i++)
            cur1=cur1.next;
        while(cur1!=cur2&&cur1!=null){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;
    }
}
