package leetcode2;

import java.util.Arrays;

public class Leetcode128 {
    /*Description
    * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
    * */

    //时间复杂度要求为O(n)时可以使用hashMap，甚至treeMap(但是它的时间复杂度又升至O(n*logn)
    public int longestConsecutive(int[] nums) {
        if(nums==null)
            return 0;
        Arrays.sort(nums);
        int result=0;
        int length=nums.length;
        for(int i=0;i<length;i++){
            int time=1;
            while(i<length-1&&nums[i+1]-nums[i]<=1){
                if(nums[i+1]-nums[i]==1) {
                    time++;
                }
                i++;
            }
            result=Math.max(time,result);
        }
        return result;
    }
}
