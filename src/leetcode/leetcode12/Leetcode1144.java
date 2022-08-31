package leetcode.leetcode12;

public class Leetcode1144 {

    public int movesToMakeZigzag(int[] nums) {
        return Math.min(getRes(nums,true),getRes(nums,false));
    }

    private int getRes(int[] nums,boolean even){
        int start = even?0:1;
        int result = 0;
        for(int i=start;i<nums.length;i+=2){
            int left = i==0?Integer.MAX_VALUE:nums[i-1];
            int right = i==nums.length-1?Integer.MAX_VALUE:nums[i+1];
            result += Math.max(0,nums[i]-Math.min(left,right)+1);
        }

        return result;
    }
}
