package leetcode.leetcode22;

import datastructure.ListNode;

public class Leetcode2181 {

    public ListNode mergeNodes(ListNode head) {
        ListNode result=new ListNode(0);
        ListNode cur=result;

        int count=0;
        while(head.next!=null){
            head=head.next;
            count+=head.val;
            if(head.val==0){
                cur.next=new ListNode(count);
                cur=cur.next;
                count=0;
            }
        }

        return result.next;
    }
}
