package leetcode.leetcode24;

public class Leetcode2393 {

    public long countSubarrays(int[] nums) {
        long result =0;
        for(int i=0;i<nums.length;i++){
            int start=i;
            while(i<nums.length-1&&nums[i+1]>nums[i])
                i++;
            result+= (long) (i - start + 2) *(i-start+1)/2;
        }
        return result;
    }


}
