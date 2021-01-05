package leetcode2;

public class Leetcode167 {
    /*Description
    *给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。
    * 函数应该返回这两个下标值 index1 和 index2，其中 index1必须小于index2。
    * 说明:
    * 返回的下标值（index1 和 index2）不是从零开始的。
    * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
    * */

    public int[] twoSum(int[] numbers, int target) {
        int left=0,right=numbers.length-1;
        while(left<right){
            int cur=numbers[left]+numbers[right];
            if(cur<target)
                left++;
            else if(cur>target)
                right--;
            else
                return new int[]{left+1,right+1};
        }
        return null;
    }
}
