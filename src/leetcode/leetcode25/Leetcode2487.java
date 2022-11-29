package leetcode.leetcode25;

import datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode2487 {

    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> s=new Stack<>();
        while(head!=null){
            while(!s.empty()&&s.peek().val<head.val){
                s.pop();
            }
            if(!s.empty()){
                s.peek().next=head;
            }
            s.add(head);
            head=head.next;
        }

        while(!s.empty()){
            head=s.pop();
        }

        return head;
    }

}
