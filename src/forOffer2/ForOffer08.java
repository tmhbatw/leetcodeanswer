package forOffer2;

public class ForOffer08 {

    public int minSubArrayLen(int target, int[] nums) {
        int j=0;
        int result=Integer.MAX_VALUE;
        int curSum=0;
        for(int i=0;i<nums.length;i++){
            while(j<nums.length&&curSum<target)
                curSum+=nums[j++];
            if(curSum>=target)
                result=Math.min(result,j-i);
            curSum-=nums[i];
        }
        return result==Integer.MAX_VALUE?0:result;
    }
}
