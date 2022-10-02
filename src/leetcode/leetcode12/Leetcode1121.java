package leetcode.leetcode12;

public class Leetcode1121 {

    public boolean canDivideIntoSubsequences(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int start=i;
            while(i<nums.length-1&&nums[i+1]==nums[i]){
                i++;
            }
            count=Math.max(count,i-start+1);
        }
        return nums.length/count>=k;
    }


}
