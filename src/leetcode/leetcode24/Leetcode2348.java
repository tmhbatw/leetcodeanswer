package leetcode.leetcode24;

public class Leetcode2348 {

    public long zeroFilledSubarray(int[] nums) {
        long result=0;
        for(int i=0;i<nums.length;i++){
            long cur=0;
            while(i<nums.length&&nums[i]==0){
                i++;
                cur++;
            }
            result+=cur*(cur+1)/2;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
    }



}
