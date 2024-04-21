package leetcode.leetcode28;

public class Leetcode2760 {


    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int result = 0;
        int curResult =0;
        int curMod = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > threshold) {
                curMod = 0;
                curResult = 0;
                continue;
            }
            if(nums[i]%2==curMod) {
                curMod=1-curMod;
                result=Math.max(result,++curResult);
                continue;
            }
            curResult = 0;
            curMod = 0;
            if(nums[i]%2==curMod) {
                curMod = 1;
                result=Math.max(result,++curResult);
            }
        }
        return result;
    }
}
