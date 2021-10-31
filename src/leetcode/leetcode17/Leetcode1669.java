package leetcode.leetcode17;

import datastructure.ListNode;

public class Leetcode1669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur=list1;
        for(int i=0;i<a-1;i++){
            cur=cur.next;
        }
        ListNode cur2=list1;
        for(int i=0;i<=b;i++)
            cur2=cur2.next;
        cur.next=list2;
        while(list2.next!=null)
            list2=list2.next;
        list2.next=cur2;
        return list1;
    }
}
