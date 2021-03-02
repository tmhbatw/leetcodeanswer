package forOffer;

public class forOffer56_1 {
    /*Description
    *一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
    * 要求时间复杂度是O(n)，空间复杂度是O(1)。
    * */

    public int[] singleNumbers(int[] nums) {
        int num=0;
        for(int cur:nums){
            num^=cur;
        }
        int index=0;
        while(((num>>index)&1)==0)
            index++;
        int num1=0,num2=0;
        for(int cur:nums){
            if(((cur>>index)&1)==1)
                num1^=cur;
            else
                num2^=cur;
        }
        return new int[]{num1,num2};
    }
}
