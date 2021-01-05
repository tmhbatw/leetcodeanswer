package leetcode2;

public class Leetcode169 {
    /*Description
    * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
    * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
    * */

    //摩尔投票法
    public int majorityElement(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int count=1,index=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==index)
                count++;
            else if(count==0){
                index=nums[i];
                count=1;
            }else
                count--;
        }
        return index;
    }
}
