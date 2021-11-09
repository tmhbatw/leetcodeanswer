package leetcode.leetcode6;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode503 {

    public int[] nextGreaterElements(int[] nums) {
        int[] res=new int[nums.length];
        Arrays.fill(res,-1);
        Stack<int[]> s=new Stack<>();

        for(int i=0;i<nums.length;i++){
            while(!s.isEmpty()&&s.peek()[0]<nums[i]){
                res[s.pop()[1]]=nums[i];
            }
            s.add(new int[]{nums[i],i});
        }
        for(int i=0;i<nums.length;i++){
            while(!s.isEmpty()&&s.peek()[0]<nums[i]){
                res[s.pop()[1]]=nums[i];
            }
        }
        return res;
    }
}
