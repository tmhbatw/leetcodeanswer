package leetcode.leetcode12;

import datastructure.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Leetcode1171 {


    Map<Integer,Integer> map=new HashMap<>();
    int[] exist=new int[1002];
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode result=new ListNode(Integer.MAX_VALUE);
        result.next=head;
        Stack<Integer> s=new Stack<>();

        int preSum=0;
        int index=1;

        map.put(0,0);
        s.add(0);

        while(head!=null){
            preSum+=head.val;
            if(map.containsKey(preSum)){
                int preIndex=map.get(preSum);
                int pop;
                while((pop=s.pop())!=preSum) {
                    map.remove(pop);
                }
                s.add(preSum);

                exist[preIndex]+=1;
                exist[index]-=1;
            }else{
                map.put(preSum,index);
                s.add(preSum);
            }

            head=head.next;
            index++;
        }

        ListNode cur=result;
        for(int i=0;i<exist.length;i++){

            if(cur.next==null)
                break;
            if(i>0)
                exist[i]+=exist[i-1];
            if(exist[i]>0){
                cur.next=cur.next.next;
            }else
                cur=cur.next;
        }

        return result.next;
    }
}
