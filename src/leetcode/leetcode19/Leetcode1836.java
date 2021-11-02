package leetcode.leetcode19;

import datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1836 {

    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Set<Integer> set=new HashSet<>();
        Set<Integer> duplicate=new HashSet<>();
        ListNode cur=head;
        while(cur!=null){
            if(set.contains(cur.val))
                duplicate.add(cur.val);
            set.add(cur.val);
            cur=cur.next;
        }
        ListNode result=new ListNode(0);
        result.next=head;
        cur=result;
        while(cur.next!=null){
            if(duplicate.contains(cur.next.val))
                cur.next=cur.next.next;
            else
                cur=cur.next;
        }
        return result.next;
    }

}
