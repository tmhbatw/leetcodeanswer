package leetcode.leetcode23;

public class Leetcode2216 {

    public int minDeletion(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            int start=i;
            while(i<nums.length-1&&nums[i+1]==nums[start]){
                i++;
                result++;
            }
            i++;
        }
        return result+(nums.length-result)%2;
    }
}
