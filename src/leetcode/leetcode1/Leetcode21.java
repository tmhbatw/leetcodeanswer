package leetcode.leetcode1;

import datastructure.ListNode;

public class Leetcode21 {
    /*Description
    *将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    * */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(0);
        ListNode cur=result;
        while(l1!=null&&l2!=null) {
            int val1 = l1.val, val2 = l2.val;
            if (val1 < val2) {
                cur.next=l1;
                l1 = l1.next;
            } else {
                cur.next=l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1!=null)
            cur.next=l1;
        else
            cur.next=l2;
        return result.next;
    }


}
