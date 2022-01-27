package leetcode.leetcode22;

public class Leetcode2149 {

    public int[] rearrangeArray(int[] nums) {
        int length=nums.length;

        int[] result=new int[length];
        int index=0;
        int j=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                continue;
            }

            result[index++]=nums[i];
            while(j<nums.length&&nums[j]>0){
                j++;
            }
            result[index++]=nums[j++];
        }

        return result;
    }
}
