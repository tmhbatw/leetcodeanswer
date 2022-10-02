package leetcode.leetcode23;

import java.util.Arrays;
import java.util.Stack;

public class Leetcode2297 {

    public long minCost(int[] nums, int[] costs) {
        int[] r1=new int[nums.length];
        int[] r2=new int[nums.length];
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!s1.empty()&&nums[s1.peek()]<=nums[i])
                r1[s1.pop()]=i;
            while(!s2.empty()&&nums[s2.peek()]>nums[i])
                r2[s2.pop()]=i;
            s1.add(i);
            s2.add(i);
        }

        long[] res=new long[nums.length];
        Arrays.fill(res,Long.MAX_VALUE);
        res[0]=0;
        for(int i=0;i<res.length;i++){
            if(res[i]==Long.MAX_VALUE)
                continue;
            res[r1[i]]=Math.min(res[r1[i]],res[i]+costs[r1[i]]);
            res[r2[i]]=Math.min(res[r2[i]],res[i]+costs[r2[i]]);
        }
        return res[res.length-1];
    }

}
