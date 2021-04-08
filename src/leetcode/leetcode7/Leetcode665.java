package leetcode.leetcode7;

public class Leetcode665 {
    /*Description
    * 给你一个长度为n的整数数组，请你判断在 最多 改变1 个元素的情况下，该数组能否变成一个非递减数列。
    * 我们是这样定义一个非递减数列的：对于数组中任意的i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
    * */

    public boolean checkPossibility(int[] nums) {
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]) {
                int temp=nums[i];
                nums[i]=nums[i-1];
                if(check(nums,i))
                    return true;
                nums[i-1]=temp;
                nums[i]=temp;
                return check(nums,i-1);
            }
        }
        return true;
    }

    private boolean check(int[] nums,int index){
        for(int i=Math.max(index,1);i<nums.length;i++){
            if(nums[i]<nums[i-1])
                return false;
        }
        return true;
    }

}
