package leetcode2;

public class Leetcode189 {
    /*Description
    * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
    * */

    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return ;
        int length=nums.length;
        k%=length;
        k=length-k;
        int[] num=new int[length];
        for(int i=0;i<length;i++){
            num[i]=nums[(i+k)%length];
        }
        for(int i=0;i<length;i++)
            nums[i]=num[i];
    }
}
