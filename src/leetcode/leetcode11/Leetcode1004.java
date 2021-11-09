package leetcode.leetcode11;

public class Leetcode1004 {

    public int longestOnes(int[] nums, int k) {
        int j=-1;
        int length=nums.length;
        int curCount=0;
        int result=0;
        for(int i=0;i<length;i++){
            while(j<length-1&&curCount+1-nums[j+1]<=k) {
                curCount+=1-nums[++j];
            }
            result=Math.max(result,j-i+1);
            curCount-=1-nums[i];
        }
        return result;
    }
}
