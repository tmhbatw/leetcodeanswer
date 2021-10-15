package leetcode.leetcode15;

import datastructure.ListNode;

public class Leetcode1474 {

    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode result=new ListNode(0);
        ListNode cur=result;

        boolean flag=true;
        int index=0;
        while(head!=null){
            if(flag){
                cur.next=new ListNode(head.val);
                cur=cur.next;
                index++;
                if(index==m) {
                    flag = false;
                    index=0;
                }
            }else{
                index++;
                if(index==n){
                    index=0;
                    flag=true;
                }
            }
            head=head.next;
        }
        return result.next;
    }

}
