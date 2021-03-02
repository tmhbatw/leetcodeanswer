package forOffer;

import java.util.Arrays;

public class forOffer03 {
    /*Description
    *找出数组中重复的数字。
    * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
    * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
    * */

    public int findRepeatNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                while(nums[nums[i]]!=nums[i]){
                    int temp=nums[nums[i]];
                    nums[nums[i]]=nums[i];
                    nums[i]=temp;
                }
                if(nums[i]!=i)
                    return nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));

        return -1;
    }
}
