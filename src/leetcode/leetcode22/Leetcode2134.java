package leetcode.leetcode22;

public class Leetcode2134 {

    public int minSwaps(int[] nums) {
        int time=0;
        for(int num:nums)
            time+=num;

        int result=Integer.MAX_VALUE;
        int cur=0;

        for(int i=0;i<nums.length*2;i++){
            cur+=nums[i%nums.length];
            result=Math.min(result,time-cur);
            if(i>=time)
                cur-=nums[(i-cur)%nums.length];
        }

        return result;
    }
}
