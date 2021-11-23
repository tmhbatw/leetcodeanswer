package leetcode.leetcode9;

import datastructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode817 {

    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        int result=0;
        while(head!=null){
            if(set.contains(head.val)){
                result++;
                while(head!=null&&set.contains(head.val)){
                    head=head.next;
                }
            }else {
                head = head.next;
            }
        }

        return result;
    }
}
