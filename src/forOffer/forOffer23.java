package forOffer;

import datastructure.ListNode;

public class forOffer23 {
    /*Description
    * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * */

    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode next=head.next;
        head.next=null;
        while(next!=null){
            ListNode temp=next.next;
            next.next=head;
            head=next;
            next=temp;
        }
        return head;
    }
}
