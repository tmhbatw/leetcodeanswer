package leetcode.leetcode16;

import java.util.Arrays;

public class Leetcode1508 {

    public int rangeSum(int[] nums, int n, int left, int right) {
        int length=nums.length;
        int[] res=new int[length*(length+1)/2];

        int index= 0;
        for(int i=0;i<length;i++){
            int cur = 0;
            for(int j=i;j<length;j++){
                cur+=nums[j];
                res[index++]=cur;
            }
        }

        Arrays.sort(res);
        int mod = 1000000007;
        int result =0;
        for(int i=left-1;i<right;i++){
            result+=res[i];
            result%=mod;
        }

        return result;
    }


}
