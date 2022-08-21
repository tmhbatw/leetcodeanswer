package leetcode.leetcode20;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

public class Leetcode1906 {

    public int[] minDifference(int[] nums, int[][] queries) {
        int[][] num=new int[nums.length+1][101];
        for(int i=0;i<nums.length;i++){
            num[i+1]=num[i].clone();
            num[i+1][nums[i]]++;
        }

        int[] result=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            result[i]=getRes(num,queries[i][0],queries[i][1]);
        }

        return result;
    }

    private int getRes(int[][] num,int i,int j){
        int[] cur=new int[101];
        int pre=0;
        int result= Integer.MAX_VALUE;
        for(int k=0;k<=100;k++){
            cur[k]=num[j+1][k]-num[i][k];
            if(cur[k]>0){
                if(pre>0){
                    result=Math.min(result,k-pre);
                }
                pre=k;
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }


}
