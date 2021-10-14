package leetcode.leetcode12;

public class Leetcode1150 {

    public boolean isMajorityElement(int[] nums, int target) {
        int count=0;
        for(int cur:nums){
            if(cur==target)
                count++;
        }
        return count>nums.length/2;
    }
}
