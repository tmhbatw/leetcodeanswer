package forOffer;

import datastructure.ListNode;

public class forOffer24 {
    /*Description
    * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
    * */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(9);
        ListNode cur=result;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else {
                cur.next = l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        if(l1!=null)
            cur.next=l1;
        else
            cur.next=l2;
        return result.next;
    }
}
