package leetcode.leetcode9;

import java.util.HashMap;
import java.util.Map;

public class Leetcode873 {

    public int lenLongestFibSubseq(int[] arr) {
        int result=0;
        int length=arr.length;

        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<length;i++)
            map.put(arr[i],i);
        int[][] dp=new int[length][length];
        for(int i=0;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(map.containsKey(arr[i]-arr[j])){
                    int index=map.get(arr[i]-arr[j]);
                    int preVal=dp[j][index];
                    result=Math.max(result,preVal+2);
                    dp[i][j]=preVal+1;
                }else
                    dp[i][j]=1;
            }
        }

        return result<3?0:result;
    }
}
