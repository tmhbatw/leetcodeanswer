package leetcode.leetcode19;

import java.util.Stack;

public class Leetcode1856 {


    public int maxSumMinProduct(int[] nums) {
        long[] sum=new long[nums.length+1];
        for(int i=0;i<nums.length;i++){
            sum[i+1]=sum[i]+nums[i];
        }

        int[] left=new int[nums.length];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!s.empty()&&nums[s.peek()]>nums[i])
                left[s.pop()]=i;
            s.add(i);
        }
        while(!s.empty())
            left[s.pop()]=nums.length;

        int[] right=new int[nums.length];
        for(int j=nums.length-1;j>=0;j--){
            while(!s.empty()&&nums[s.peek()]>=nums[j])
                right[s.pop()]=j;
            s.add(j);
        }
        while(!s.empty())
            right[s.pop()]=-1;

        long result = 0;
        for(int i=0;i<nums.length;i++){
            result=Math.max(result,nums[i]*(sum[right[i]]-sum[left[i]+1]));
        }
        return (int)(result%1000000007);
    }


}
