package leetcode3;

public class Leetcode287 {
    /*Description
    * 给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），可知至少存在一个重复的整数。
    * 设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
    * */

    public int findDuplicate(int[] nums) {
        boolean[] reached=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            if(reached[nums[i]])
                return nums[i];
            reached[nums[i]]=true;
        }
        return 0;
    }
}
