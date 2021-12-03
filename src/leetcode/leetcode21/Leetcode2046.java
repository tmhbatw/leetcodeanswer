package leetcode.leetcode21;

import datastructure.ListNode;

public class Leetcode2046 {

    public ListNode sortLinkedList(ListNode head) {
        int[] num=new int[10002];
        while(head!=null){
            num[head.val+5000]++;
            head=head.next;
        }

        ListNode result=new ListNode(-1);
        ListNode cur=result;
        for(int i=0;i<num.length;i++){
            for(int j=0;j<num[i];j++){
                cur.next=new ListNode(i-5000);
                cur=cur.next;
            }
        }

        return result.next;
    }
}
