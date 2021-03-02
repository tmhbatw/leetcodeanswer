package forOffer;

public class forOffer39 {
    /*Description
    * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    * */

    public int majorityElement(int[] nums) {
        int num=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(count==0){
                num=nums[i];
                count=1;
            }else {
                if (nums[i] != num) {
                    count--;
                } else
                    count++;
            }
        }
        return num;
    }
}
