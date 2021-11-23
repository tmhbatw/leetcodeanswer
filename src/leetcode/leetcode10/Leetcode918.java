package leetcode.leetcode10;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leetcode918 {

    public int maxSubarraySumCircular(int[] nums) {
        Deque<int[]> dq=new ArrayDeque<>();
        int curSum=0;
        dq.add(new int[]{0,-1});
        int result=Integer.MIN_VALUE;

        int length=nums.length;
        for(int i=0;i<length*2;i++){
            int index=i%length;
            curSum+=nums[index];

            result=Math.max(result,curSum-dq.peekFirst()[0]);
            while(!dq.isEmpty()&&dq.peekLast()[0]>curSum)
                dq.pollLast();
            dq.add(new int[]{curSum,i});
            if(dq.peekFirst()[1]==i-length)
                dq.pollFirst();
        }
        return result;
    }

    private void print(Deque<int[]> dq){
        for(int[] cur:dq){
            System.out.print(Arrays.toString(cur)+" ");
        }
        System.out.println("");
    }
}
