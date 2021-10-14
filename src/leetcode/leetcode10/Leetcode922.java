package leetcode.leetcode10;

public class Leetcode922 {
    public int[] sortArrayByParityII(int[] nums) {
        int index1=1;
        for(int i=0;i<nums.length;i+=2){
            //需要转换
            if(nums[i]%2==1){
                while(nums[index1]%2==1)
                    index1+=2;
                int temp=nums[i];
                nums[i]=nums[index1];
                nums[index1]=temp;
            }
        }
        return nums;
    }

}
