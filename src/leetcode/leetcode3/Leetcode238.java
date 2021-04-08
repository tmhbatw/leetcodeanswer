package leetcode.leetcode3;

public class Leetcode238 {
    /*Description
    * 给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，
    * 其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。
    * */

    public int[] productExceptSelf(int[] nums) {
        if(nums==null||nums.length==0)
            return new int[0];
        int length=nums.length;
        int[] result=new int[length];
        int right=1;
        for(int j=length-1;j>=0;j--){
            result[j]=right*nums[j];
            right=result[j];
        }
        int left=1;
        for(int i=0;i<length-1;i++) {
            result[i] = left * result[i + 1];
            left*=nums[i];
        }
        result[length-1]=left;
        return result;
    }
}
