package leetcode.leetcode23;

public class Leetcode2210 {

    public int countHillValley(int[] nums) {
        int result=0;
        boolean small = false;
        boolean big = false;

        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]) {
                if(big){
                    result++;
                }

                small = true;
                big = false;
            }
            else if(nums[i]>nums[i+1]){
                if(small)
                    result++;
                small = false;
                big = true;
            }
        }
        return result;
    }
}
