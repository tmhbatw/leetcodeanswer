package leetcode.leetcode11;

import datastructure.ListNode;

import java.util.Stack;

public class Leetcode1019 {

    public int[] nextLargerNodes(ListNode head) {
        int length=getLength(head);
        int[] result=new int[length];
        Stack<int[]> s=new Stack<>();
        int index=0;
        while(head!=null){
            while(!s.isEmpty()&&s.peek()[0]<head.val){
                result[s.pop()[1]]=head.val;
            }
            s.add(new int[]{head.val,index++});
            head=head.next;
        }
        return result;
    }

    private int getLength(ListNode head){
        int length=0;
        while(head!=null){
            length++;
            head=head.next;
        }
        return length;
    }
}
