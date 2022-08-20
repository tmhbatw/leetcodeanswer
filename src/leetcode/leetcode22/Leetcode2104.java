package leetcode.leetcode22;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Leetcode2104 {

    public long subArrayRanges(int[] nums) {
        return getRes(nums,false)-getRes(nums,true);
    }

    private long getRes(int[] nums,boolean small){
        int length=nums.length;
        int[] left=new int[length];
        Stack<Integer> q=new Stack<>();
        for(int i=0;i<nums.length;i++){
            if(small) {
                while (!q.empty() &&nums[q.peek()]>nums[i]){
                    left[q.pop()]=i;
                }
            }else{
                while (!q.empty() &&nums[q.peek()]<nums[i]){
                    left[q.pop()]=i;
                }
            }
            q.add(i);
        }
        while(!q.empty())
            left[q.pop()]=nums.length;

        int[] right=new int[length];
        for(int j=nums.length-1;j>=0;j--){
            if(small){
                while (!q.empty() &&nums[q.peek()]>=nums[j]){
                    right[q.pop()]=j;
                }
            }else{
                while(!q.empty()&&nums[q.peek()]<=nums[j]){
                    right[q.pop()]=j;
                }
            }
            q.add(j);
        }
        while(!q.empty())
            right[q.pop()]=-1;

        long result=0;
        for(int i=0;i<nums.length;i++){
            result+=(long)(nums[i])*(left[i]-i)*(i-right[i]);
        }
        return result;
    }
}
