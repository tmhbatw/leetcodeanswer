package leetcode.leetcode21;

public class Leetcode2036 {
    public long maximumAlternatingSubarraySum(int[] nums) {
        long result=Integer.MIN_VALUE;

        long m1=0;
        long m2=Integer.MAX_VALUE;
        long preSum=0;

        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                preSum+=nums[i];
            }else{
                preSum-=nums[i];
            }

            result=Math.max(result,Math.max(preSum-m1,-preSum-m2));
            if(i%2==0)
                m2=Math.min(-preSum,m2);
            else
                m1=Math.min(preSum,m1);
        }
        return result;
    }
}
