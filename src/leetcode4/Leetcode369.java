package leetcode4;

import datastructure.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode369 {
    /*Description
    * 用一个 非空 单链表来表示一个非负整数，然后将这个整数加一。
    * 你可以假设这个整数除了 0 本身，没有任何前导的 0。
    * 这个整数的各个数位按照 高位在链表头部、低位在链表尾部的顺序排列。
    * */

    public ListNode plusOne(ListNode head) {
        if(head==null)
            return null;
        Map<ListNode,ListNode> map=new HashMap<>();
        map.put(head,new ListNode(0));
        ListNode pre=head;
        ListNode cur=head.next;
        while(cur!=null){
            map.put(cur,pre);
            pre=cur;
            cur=cur.next;
        }
        int count=1;
        while(count!=0){
            int curVal=count+pre.val;
            pre.val=curVal%10;
            count=curVal/10;
            pre=map.get(pre);
        }
        if(head.val==0) {
            ListNode result=map.get(head);
            result.next=head;
            return result;
        }
        return head;
    }
}
