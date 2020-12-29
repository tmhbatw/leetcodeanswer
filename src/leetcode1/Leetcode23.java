package leetcode1;

import datastructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode23 {
    /*Description
    * 给你一个链表数组，每个链表都已经按升序排列。
    * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
    * */

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode cur:lists){
            if(cur!=null)
            pq.add(cur);
        }
        ListNode result=new ListNode(0);
        ListNode cur=result;
        while (!pq.isEmpty()) {
            ListNode curr=pq.poll();
            cur.next=curr;
            cur=cur.next;
            if(curr.next!=null)
                pq.add(curr.next);
        }
        return result.next;
    }
}
