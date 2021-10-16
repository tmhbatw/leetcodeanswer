package leetcode.leetcode19;

public class Leetcode1800 {
    public int maxAscendingSum(int[] nums) {
        int count=0;
        int length=nums.length;
        for(int i=0;i<nums.length;i++){
            int sum=nums[i];
            while(i<length-1&&nums[i+1]>nums[i])
                sum+=nums[++i];
            count=Math.max(sum,count);
        }
        return count;
    }
}
