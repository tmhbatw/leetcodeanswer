package leetcode.leetcode1;

import java.util.Arrays;

public class Leetcode75 {
    /*Description
    * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
    * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
    * */

    /*Solution
    * 遍历数组，如果是0则移到开头，如果是2则移到结束，如果是1则不动
    * */

    public void sortColors(int[] nums) {
        int left=0,right=nums.length-1;
        for(int i=0;i<nums.length;i++){
            while(nums[i]==0||nums[i]==2){
                if(i==left&&nums[i]==0||i>=right&&nums[i]==2)
                    break;
                if(nums[i]==0){
                    nums[i]=nums[left];
                    nums[left++]=0;
                }else if(nums[i]==2){
                    nums[i]=nums[right];
                    nums[right--]=2;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] num=new int[]{2,0,2,1,1,0,1,0,2,2};
        new Leetcode75().sortColors(num);
        System.out.println(Arrays.toString(num));
    }
}
