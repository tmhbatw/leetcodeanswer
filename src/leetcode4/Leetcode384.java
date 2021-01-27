package leetcode4;

public class Leetcode384 {
    /*Description
    * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
    * 实现 Solution class:
    * Solution(int[] nums) 使用整数数组 nums 初始化对象
    * int[] reset() 重设数组到它的初始状态并返回
    * int[] shuffle() 返回数组随机打乱后的结果
    * */

    class Solution {
        int[] nums;

        public Solution(int[] nums) {
            this.nums=nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] result=nums.clone();
            int number=result.length;
            for(int i=0;i<number;i++){
                int index=(int)(Math.random()*(number-i))+i;
                int temp=result[i];
                result[i]=result[index];
                result[index]=temp;
            }
            return result;
        }
    }
}
