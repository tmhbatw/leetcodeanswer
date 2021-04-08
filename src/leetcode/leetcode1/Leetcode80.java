package leetcode.leetcode1;

public class Leetcode80 {
    /*Description
    * 给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
    * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
    * */

    public int removeDuplicates(int[] nums) {
        int slow=0;
        int length=nums.length;
        for(int i=0;i<nums.length;i++){
            int curNum=nums[i];
            int time=1;
            while(i<length-1&&curNum==nums[i+1]){
                i+=1;
                time++;
            }
            time=Math.min(time,2);
            while(time-->0)
                nums[slow++]=curNum;
        }
        return slow;
    }
}
