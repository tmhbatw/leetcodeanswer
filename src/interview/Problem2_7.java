package interview;

import datastructure.ListNode;

public class Problem2_7 {
    /*Description
    * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，
    * 而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
    * */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA=0;
        ListNode cur=headA;
        while(cur!=null){
            lengthA++;
            cur=cur.next;
        }
        int lengthB=0;
        cur=headB;
        while(cur!=null){
            lengthB++;
            cur=cur.next;
        }
        if(lengthA<lengthB){
            for(int i=lengthA;i<lengthB;i++){
                headB=headB.next;
            }
        }
        else{
            for(int i=lengthB;i<lengthA;i++){
                headA=headA.next;
            }
        }
        for(int i=0;i<Math.min(lengthA,lengthB);i++){
            if(headA==headB)
                return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}
