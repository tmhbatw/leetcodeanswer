package leetcode.leetcode20;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode1950 {

    public int[] findMaximums(int[] nums) {
        int[] right=new int[nums.length];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!s.empty()&&nums[s.peek()]>nums[i])
                right[s.pop()]=i;
            s.add(i);
        }
        while(!s.empty())
            right[s.pop()]=nums.length;

        int[] left=new int[nums.length];
        for(int j=nums.length-1;j>=0;j--){
            while(!s.empty()&&nums[s.peek()]>=nums[j])
                left[s.pop()]=j;
            s.add(j);
        }
        while(!s.empty())
            left[s.pop()]=-1;

        int[][] res=new int[right.length][2];
        for(int i=0;i<res.length;i++){
            res[i]=new int[]{nums[i],right[i]-left[i]-1};
        }
        Arrays.sort(res,(o1,o2)->{
            if(o1[1]==o2[1])
                return o2[0]-o1[0];
            return o2[1]-o1[1];
        });

        int[] result=new int[left.length];
        int i=0;
        int max=Integer.MIN_VALUE;
        for(int j=result.length-1;j>=0;j--){
            while(i<result.length&&res[i][1]>j){
                max=Math.max(max,res[i++][0]);
            }
            result[j]=max;
        }
        return result;
    }


}
