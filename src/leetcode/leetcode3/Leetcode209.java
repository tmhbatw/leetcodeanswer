package leetcode.leetcode3;

public class Leetcode209 {
    /*Description
    * 给定一个含有n个正整数的数组和一个正整数s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，
    * 并返回其长度。如果不存在符合条件的子数组，返回 0。
    * */

    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int length=nums.length;
        int curSum=0;
        int last=-1;
        for(int i=0;i<length;i++){
            curSum+=nums[i];
            if(curSum>=s){
                last=i;
                break;
            }
        }
        if(last==-1)
            return 0;
        int result=last+1;
        for(int i=0;i<length;i++){
            while(curSum<s){
                if(last==length-1)
                    return result;
                curSum+=nums[++last];
            }
            result=Math.min(result,last-i+1);
            curSum-=nums[i];
        }
        return result;
    }
}
