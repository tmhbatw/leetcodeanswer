package interview;

import datastructure.ListNode;

public class Problem2_4 {
    /*Description
    * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。
    * 如果链表中包含 x，x 只需出现在小于 x 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
    * */

    public ListNode partition(ListNode head, int x) {
        ListNode result=new ListNode(-1);
        ListNode curLeft=result;
        ListNode rightHead=new ListNode(-1);
        ListNode curRight=rightHead;
        while(head!=null){
            if(head.val<x){
                curLeft.next=head;
                curLeft=curLeft.next;
            }else{
                curRight.next=head;
                curRight=curRight.next;
            }
            head=head.next;
        }
        curLeft.next=rightHead.next;
        curRight.next=null;
        return result.next;
    }
}
