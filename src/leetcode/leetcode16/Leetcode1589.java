package leetcode.leetcode16;

import java.util.Arrays;

public class Leetcode1589 {

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] time=new int[nums.length+1];
        for(int[] req:requests){
            time[req[0]]+=1;
            time[req[1]+1]-=1;
        }

        for(int i=1;i<time.length;i++){
            time[i]+=time[i-1];
        }

        Arrays.sort(nums);
        Arrays.sort(time);

        long result=0;
        int mod=1000000007;
        for(int j=nums.length-1;j>=0;j--){
            result+= (long)nums[j]*(time[j+1]);
            result%=mod;
        }

        return (int)result;
    }


}
