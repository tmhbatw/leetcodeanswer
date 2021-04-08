package leetcode.leetcode2;

import datastructure.ListNode;

public class Leetcode160 {
    /*Description
    * 编写一个程序，找到两个单链表相交的起始节点。
    * */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1=getLength(headA);
        int length2=getLength(headB);
        if(length2>length1){
            int length=length2-length1;
            while(length-->0)
                headB=headB.next;
        }else{
            int length=length1-length2;
            while(length-->0)
                headA=headA.next;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }

    private int getLength(ListNode headA){
        int result=0;
        while(headA!=null){
            result++;
            headA=headA.next;
        }
        return result;
    }

}
