package leetcode3;

public class Leetcode260 {
    /*Description
    *给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
    * */

    public int[] singleNumber(int[] nums) {
        int xorVal=0;
        for(int cur:nums){
            xorVal^=cur;
        }
        int index=0;
        while(((xorVal>>index)&1)!=1)
            index++;
        int a=0,b=0;
        for(int cur:nums){
            if(((cur>>index)&1)==1)
                a^=cur;
            else
                b^=cur;
        }
        return new int[]{a,b};
    }
}
