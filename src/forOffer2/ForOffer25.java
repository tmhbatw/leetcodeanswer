package forOffer2;

import datastructure.ListNode;

public class ForOffer25 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverseNode(l1);
        l2=reverseNode(l2);
        ListNode result=new ListNode(-1);
        ListNode cur=result;
        int count=0;
        while(l1!=null||l2!=null){
            int curVal=count;
            if(l1!=null){
                curVal+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                curVal+=l2.val;
                l2=l2.next;
            }
            cur.next=new ListNode(curVal%10);
            cur=cur.next;
            count=curVal/10;
        }
        if(count!=0)
            cur.next=new ListNode(count);
        return reverseNode(result.next);
    }

    private ListNode reverseNode(ListNode l){
        ListNode next=l.next;
        l.next=null;
        while(next!=null){
            ListNode temp=next.next;
            next.next=l;
            l=next;
            next=temp;
        }
        return l;
    }
}
