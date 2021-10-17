package leetcode.leetcode20;

public class Leetcode1909 {

    public boolean canBeIncreasing(int[] nums) {
        boolean changed=false;
        int pre=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=pre){
                if(changed)
                    return false;
                changed=true;
                if(i==1||i>=2&&nums[i]>nums[i-2])
                    pre=nums[i];
                else
                    pre=nums[i-1];
            }
            else
                pre=nums[i];
        }
        return true;
    }
}
