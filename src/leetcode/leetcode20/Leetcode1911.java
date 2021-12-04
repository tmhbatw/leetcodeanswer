package leetcode.leetcode20;

public class Leetcode1911 {

    public long maxAlternatingSum(int[] nums) {
        if(nums.length==1)
            return nums[0];

        //该正的了
        long l1=Math.max(nums[0]-nums[1],0);
        //该负的了
        long l2=Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            long temp=l1;
            l1=Math.max(l1,l2-nums[i]);
            l2=Math.max(l2,l1+nums[i]);
        }

        return Math.max(l1,l2);

    }
}
