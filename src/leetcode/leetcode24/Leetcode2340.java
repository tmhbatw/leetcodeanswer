package leetcode.leetcode24;

public class Leetcode2340 {

    public int minimumSwaps(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            min=Math.min(num,min);
            max=Math.max(num,max);
        }

        int result=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==min){
                result+=i;
                break;
            }
        }
        for(int j=nums.length-1;j>=0;j--){
            if(nums[j]==max){
                if(j<result){
                    result--;
                }
                result+=nums.length-1-j;
            }
        }
        return result;
    }


}
