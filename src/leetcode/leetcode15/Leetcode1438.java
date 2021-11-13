package leetcode.leetcode15;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode1438 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max=new ArrayDeque<>();
        Deque<Integer> min=new ArrayDeque<>();
        int j=0;
        int result=0;

        for(int i=0;i<nums.length;i++){
            while(j<nums.length&&(max.isEmpty()||
                    (max.peekFirst()-nums[j]<=limit&&
                            nums[j]-min.peekFirst()<=limit))){
                int add=nums[j++];
                while (!max.isEmpty()&&max.peekLast()<add){
                    max.pollLast();
                }
                max.add(add);
                while(!min.isEmpty()&&min.peekLast()>add){
                    min.pollLast();
                }
                min.add(add);
            }
            result=Math.max(result,j-i+1);
            if(max.peekFirst()==nums[i])
                max.pollFirst();
            if(min.peekFirst()==nums[i])
                min.pollFirst();
        }
        return result;
    }
}
