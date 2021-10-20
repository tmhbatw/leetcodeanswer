package forOffer2;

import datastructure.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class ForOffer78 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        PriorityQueue<ListNode> p=new PriorityQueue<>((o1,o2)->{
            return o1.val-o2.val;
        });
        for(ListNode cur:lists) {
            if(cur!=null)
                p.add(cur);
        }
        ListNode result=new ListNode(-1);
        ListNode cur=result;
        while(!p.isEmpty()){
            ListNode c=p.poll();
            cur.next=new ListNode(c.val);
            cur=cur.next;
            if(c.next!=null)
                p.add(c.next);
        }
        return result.next;
    }
}
