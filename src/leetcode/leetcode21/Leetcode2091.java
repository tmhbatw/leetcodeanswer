package leetcode.leetcode21;

public class Leetcode2091 {

    public int minimumDeletions(int[] nums) {
        int i1=-1;
        int i2=-1;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
                i1=i;
            }
            if(nums[i]<min){
                min=nums[i];
                i2=i;
            }
        }

        min=Math.min(i1,i2);
        max=Math.max(i1,i2);

        int result=Math.min(max+1,nums.length-min);
        return Math.min(result,nums.length-(max-min-1));
    }

}
