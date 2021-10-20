package forOffer2;

import datastructure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ForOffer77 {

    public ListNode sortList(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        Collections.sort(list);
        ListNode result=new ListNode(-1);
        ListNode cur=result;
        for(int i=0;i<list.size();i++){
            cur.next=new ListNode(i);
            cur=cur.next;
        }
        return result.next;
    }
}
