package leetcode3;

import datastructure.ListNode;

public class Leetcode237 {
    /*Description
    *请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
    * */
    public void deleteNode(ListNode node) {
        while(node.next.next!=null){
            node.val=node.next.val;
            node=node.next;
        }
        node.val=node.next.val;
        node.next=null;
    }
}
