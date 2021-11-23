package leetcode.leetcode10;

public class Leetcode985 {

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int curSum=0;

        for(int num:nums){
            if(num%2==0)
                curSum+=num;
        }

        int[] result=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            if(nums[queries[i][1]]%2==0)
                curSum-=nums[queries[i][1]];
            nums[queries[i][1]]+=queries[i][0];
            if(nums[queries[i][1]]%2==0)
                curSum+=nums[queries[i][1]];
            result[i]=curSum;
        }
        return result;
    }
}
