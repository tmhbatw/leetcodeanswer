package leetcode.leetcode18;

public class Leetcode1708 {

    public int[] largestSubarray(int[] nums, int k) {
        int[] result=new int[k];

        int max=nums[0];
        int index=0;
        for(int i=0;i<nums.length-k+1;i++){
            if(nums[i]>max){
                max=nums[i];
                index=i;
            }
        }
        System.arraycopy(nums,index,result,0,k);
        return result;
    }
}
