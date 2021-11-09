package leetcode.leetcode8;

import datastructure.ListNode;

public class Leetcode725 {

    ListNode pre;
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length=getLength(head);
        int l=length/k+1;
        int left=length%k;
        pre=head;
        ListNode[] result=new ListNode[k];
        for(int i=0;i<k;i++){
            if(i==left)
                l--;
            result[i]=getRes(l);
        }
        return result;
    }

    private ListNode getRes(int l){
        ListNode result=pre;
        ListNode cur=pre;
        while(--l>0)
            cur=cur.next;
        if(cur==null)
            return null;
        pre=cur.next;
        cur.next=null;
        return result;
    }

    private int getLength(ListNode head){
        int length=0;
        while(head!=null){
            length++;
            head=head.next;
        }
        return length;
    }
}
