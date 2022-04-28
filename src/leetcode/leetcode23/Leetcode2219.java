package leetcode.leetcode23;

public class Leetcode2219 {

    public long maximumSumScore(int[] nums) {
        long result = Long.MIN_VALUE;
        long sum  = 0;
        for(int num:nums)
            sum+=num;

        long cur=0;
        for(int num:nums){
            cur+=num;
            result=Math.max(result,Math.max(cur,sum));
            sum-=num;
        }

        return result;
    }
}
