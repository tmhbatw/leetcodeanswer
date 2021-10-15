package leetcode.leetcode15;

public class Leetcode1413 {

    public int minStartValue(int[] nums) {
        int res=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            res=Math.min(res,sum);
        }
        return -res+1;
    }
}
