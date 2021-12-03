package leetcode.leetcode21;

import datastructure.ListNode;

import java.util.ArrayList;

public class Leetcode2058 {

    int preIndex=-1;
    int minPreIndex=-1;
    int result=Integer.MAX_VALUE;

    int pre=100;
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int index=0;
        while(head.next!=null){
            index++;
            int status=getStatus(head.val,head.next.val);
            if(pre+status==0){
                if(minPreIndex==-1){
                    minPreIndex=index;
                }else{
                    result=Math.min(index-preIndex,result);
                }
                preIndex=index;
            }
            pre=status;
            head=head.next;
        }
        return result==Integer.MAX_VALUE?new int[]{-1,-1}:new int[]{result,preIndex-minPreIndex};
    }

    private int getStatus(int val1,int val2){
        if(val1<val2)
            return -1;
        if(val1>val2)
            return 1;
        return 100;
    }
}
