package leetcode.leetcode5;

public class Leetcode413 {

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<=2)
            return 0;

        int result=0;
        int d=nums[1]-nums[0];
        int cur=0;

        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==d){
                cur++;
            }else{
                d=nums[i]-nums[i-1];
                cur=0;
            }
            result+=cur;
        }

        return result;
    }
}
