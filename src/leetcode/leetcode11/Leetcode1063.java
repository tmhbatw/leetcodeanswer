package leetcode.leetcode11;

import java.util.Stack;

public class Leetcode1063 {

    public int validSubarrays(int[] nums) {
        Stack<int[]> s=new Stack<>();
        int[] right=new int[nums.length];
        s.add(new int[]{Integer.MIN_VALUE,-1});
        for(int i=0;i<nums.length;i++){
            while(nums[i]<s.peek()[0]){
                right[s.pop()[1]]=i;
            }
            s.add(new int[]{nums[i],i});
        }
        while(s.size()>1){
            right[s.pop()[1]]=nums.length;
        }
        int result=0;
        for(int i=0;i<right.length;i++){
            result+=right[i]-i;
        }
        return result;
    }
}
