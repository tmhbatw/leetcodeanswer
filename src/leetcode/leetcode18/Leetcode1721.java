package leetcode.leetcode18;

import datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1721 {

    public ListNode swapNodes(ListNode head, int k) {
        List<ListNode> list=new ArrayList<>();
        ListNode cur=head;
        while(cur!=null){
            list.add(cur);
            cur=cur.next;
        }

        int temp=list.get(k-1).val;
        list.get(k-1).val=list.get(list.size()-k).val;
        list.get(list.size()-k).val=temp;

        return head;
    }
}
