package leetcode.leetcode4;

import java.util.ArrayList;
import java.util.List;

public class Leetcode398 {
    /*Description
    * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
    * 注意：
    * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
    * */

    class Solution {
        int[] nums;
        public Solution(int[] nums) {
            this.nums=nums;
        }

        public int pick(int target) {
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                if(target==nums[i])
                    list.add(i);
            }
            return list.get((int)(Math.random()*list.size()));
        }
    }
}
