package leetcode.leetcode8;

public class Leetcode713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long cur=1;
        int result=0;
        int j=0;

        for(int i=0;i<nums.length;i++){
            j=Math.max(j,i);

            while(j<nums.length&&cur*nums[j]<k)
                cur*=nums[j++];

            result+=j-i;
            cur/=nums[i];
            cur=Math.max(1,cur);
        }

        return result;
    }
}
