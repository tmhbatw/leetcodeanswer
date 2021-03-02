package forOffer;

import datastructure.ListNode;

public class forOffer18 {
    /*Description
    * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
    * 返回删除后的链表的头节点。
    * 注意：此题对比原题有改动
    * */

    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val)
            return head.next;
        ListNode res=head;
        while(head.next!=null){
            if(head.next.val==val){
                head.next=head.next.next;
                return res;
            }else
                head=head.next;
        }
        return res;
    }
}
