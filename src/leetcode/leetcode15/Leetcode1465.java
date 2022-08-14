package leetcode.leetcode15;

import java.util.Arrays;

public class Leetcode1465 {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long result =  getMaxEdge(horizontalCuts,h)*getMaxEdge(verticalCuts,w);
        int mod=1000000007;

        return (int) (result%mod);
    }

    private  long getMaxEdge(int[] num , int edge) {
        Arrays.sort(num);
        int res=0;
        int pre=0;
        for(int n:num){
            res=Math.max(res,n-pre);
            pre = n;
        }
        return Math.max(res,edge-pre);
    }
}
