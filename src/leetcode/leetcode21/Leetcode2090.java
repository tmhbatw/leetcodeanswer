package leetcode.leetcode21;

import java.util.Arrays;

public class Leetcode2090 {

    public int[] getAverages(int[] nums, int k) {
        int[] res=new int[nums.length];
        if(nums.length<2*k+1){
            Arrays.fill(res,-1);
            return res;
        }
        long cur=0;
        for(int i=0;i<nums.length;i++){
            if(i<k||nums.length-i<=k){
                res[i]=-1;
                continue;
            }
            if(i==k){
                for(int j=i-k;j<=i+k;j++){
                    cur+=nums[j];
                }
            }else{
                cur+=nums[i+k]-nums[i-k-1];
            }
            res[i]= (int) (cur/(2*k+1));
        }

        return res;
    }


}
