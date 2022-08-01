package leetcode.leetcode24;

public class Leetcode2357 {

    public int minimumOperations(int[] nums) {
        int count = 0;
        int min=getMin(nums);
        while(min<Integer.MAX_VALUE){
            for(int i=0;i<nums.length;i++){
                if(nums[i]>0)
                    nums[i]-=min;
            }
            min=getMin(nums);
            count++;
        }
        return count;
    }

    private int getMin(int[] nums){
        int min=Integer.MAX_VALUE;
        for(int num:nums){
            if(num==0)
                continue;
            min=Math.min(min,num);
        }
        return min;
    }
}
