package leetcode.leetcode23;

public class Leetcode2202 {

    public int maximumTop(int[] nums, int k) {
        if(nums.length==1&&k%2==1)
            return -1;

        int max=Integer.MIN_VALUE;
        for(int i=0;i<Math.min(nums.length,k-1);i++){
            max=Math.max(max,nums[i]);
        }

        if(k<nums.length){
            max=Math.max(max,nums[k]);
        }

        return max;
    }
}
