package leetcode.leetcode5;

import datastructure.ListNode;

public class Leetcode445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        l1=reverse(l1);
        l2=reverse(l2);
        int count=0;
        ListNode result=new ListNode(0);
        ListNode cur=result;
        while(l1!=null||l2!=null||count!=0){
            int val1=0;
            if(l1!=null){
                val1=l1.val;
                l1=l1.next;
            }
            int val2=0;
            if(l2!=null){
                val2=l2.val;
                l2=l2.next;
            }
            int curVal=val1+val2+count;
            cur.next=new ListNode(curVal%10);
            cur=cur.next;
            count=curVal/10;
        }
        return reverse(result.next);
    }

    private ListNode reverse(ListNode l){
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
