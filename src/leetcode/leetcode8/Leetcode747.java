package leetcode.leetcode8;

public class Leetcode747 {
    /*Description
    * 在一个给定的数组nums中，总是存在一个最大元素 。
    * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
    * 如果是，则返回最大元素的索引，否则返回-1。
    * */
    public int dominantIndex(int[] nums) {
        int first=0,second=0;
        int index=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=first){
                second=first;
                first=nums[i];
                index=i;
            }else if(nums[i]>second)
                second=nums[i];
        }
        return first>=(second*2)?index:-1;
    }

}
