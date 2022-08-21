package leetcode.leetcode21;

import datastructure.ListNode;

public class Leetcode2074 {

    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode result=new ListNode(-1);
        ListNode curNode=result;
        int time=1;
        while(head!=null){
            ListNode cur=new ListNode(-1);
            ListNode curr=cur;
            for(int i=0;i<time;i++){
                if(head==null){
                    curNode.next=reverse(cur.next,i);
                    return result.next;
                }
                curr.next=new ListNode(head.val);
                curr=curr.next;
                head=head.next;
            }
            curNode.next=reverse(cur.next,time);
            time++;
            while(curNode.next!=null)
                curNode =curNode.next;
        }

        return result.next;

    }

    private ListNode reverse(ListNode node, int time){
        if(time%2==1){
            return node;
        }
        ListNode next=node.next;
        ListNode pre=node;
        pre.next=null;
        while(next!=null){
            ListNode temp=next.next;
            next.next=pre;
            pre=next;
            next=temp;
        }
        return pre;
    }

    public static void main(String[] args){
        ListNode h=new ListNode(1);
        h.next=new ListNode(2);
        h.next.next=new ListNode(3);
        h.next.next.next=new ListNode(4);

        ListNode cur = new Leetcode2074().reverse(h,4);
        while(cur!=null){
            System.out.print(cur.val+"  ");
            cur=cur.next;
        }
    }

}
