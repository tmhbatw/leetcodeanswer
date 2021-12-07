package leetcode.leetcode8;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode795 {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int length=nums.length;
        int[] l=new int[length];
        int[] r=new int[length];

        Stack<int[]> s=new Stack<>();
        s.add(new int[]{Integer.MAX_VALUE,-1});
        for(int i=0;i<nums.length;i++){
            while(s.peek()[0]<=nums[i]){
                int[] cur=s.pop();
                r[cur[1]]=i;
            }
            l[i]=s.peek()[1];
            s.add(new int[]{nums[i],i});
        }

        while(s.peek()[0]<Integer.MAX_VALUE){
            r[s.pop()[1]]=length;
        }

        int result=0;

        for(int i=0;i<length;i++){
            if(nums[i]<=right&&nums[i]>=left){
                result+=(r[i]-i)*(i-l[i]);
            }
        }

        return result;
    }
}
