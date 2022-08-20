package leetcode.leetcode10;

import java.util.Stack;

public class Leetcode915 {

    public int partitionDisjoint(int[] nums) {
        Stack<Integer> s=new Stack<>();
        for(int j=nums.length-1;j>=0;j--){
            if(!s.empty()&&s.peek()<nums[j])
                continue;
            s.add(nums[j]);
        }

        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            max=Math.max(num,max);
            if(!s.empty()&&s.peek()==num)
                s.pop();

            if(s.empty()||s.peek()>=max)
                return i+1;
        }
        return nums.length;
    }

}
