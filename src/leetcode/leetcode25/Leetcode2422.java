package leetcode.leetcode25;

public class Leetcode2422 {

    public int minimumOperations(int[] nums) {
        int result=0;
        int l=0,r=nums.length-1;
        while(l<r){
            if(nums[l]==nums[r]){
                l++;
                r--;
                continue;
            }
            result++;
            if(nums[l]<nums[r]){
                nums[l+1]+=nums[l++];
            }else{
                nums[r-1]+=nums[r--];
            }
        }
        return result;
    }

}
