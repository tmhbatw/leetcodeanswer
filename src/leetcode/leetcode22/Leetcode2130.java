package leetcode.leetcode22;

import datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2130 {

    public int pairSum(ListNode head) {
        List<Integer> list=new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }

        int result=0;
        for(int i=0;i<list.size()/2;i++)
            result=Math.max(result,list.get(i)+list.get(list.size()-1-i));

        return result;
    }
}
