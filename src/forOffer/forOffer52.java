package forOffer;

import datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class forOffer52 {
    /*Description
    * 输入两个链表，找出它们的第一个公共节点。
    * */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet<>();
        while (headA!=null) {
            set.add(headA);
            headA=headA.next;
        }
        while(!set.contains(headB)&&headB!=null)
            headB=headB.next;
        return headB;
    }
}
