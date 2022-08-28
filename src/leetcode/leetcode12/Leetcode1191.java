package leetcode.leetcode12;

import java.util.Arrays;

public class Leetcode1191 {

    public int kConcatenationMaxSum(int[] arr, int k) {
        int sum= Arrays.stream(arr).sum();
        int mod=1000000007;
        long result=getRes(arr,Math.min(k,2)*arr.length);
        if (sum > 0) {
            result += (long)sum *Math.max(0,(k-2));
        }
        return (int) (result%mod);
    }

    private int getRes(int[] arr,int k){
        int cur=0;
        int min=0;
        int res=0;
        for(int i=0;i<k;i++){
            int index=i%arr.length;
            cur+=arr[index];
            res=Math.max(res,cur-min);
            min=Math.min(min,cur);
        }
        return res;
    }

}
