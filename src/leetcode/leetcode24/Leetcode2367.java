package leetcode.leetcode24;

public class Leetcode2367 {

    public int arithmeticTriplets(int[] nums, int diff) {
        int result =0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[j]-nums[i]==diff&&nums[k]-nums[j]==diff)
                        result++;
                }
            }
        }
        return result;
    }
}
