package leetcode.leetcode12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode1140 {

    int[][] map=new int[200][101];
    //Map<Integer,Integer> map;
    int[] sum;
    public int stoneGameII(int[] piles) {
        this.sum=new int[piles.length+1];
        for(int i=0;i<piles.length;i++)
            sum[i+1]=sum[i]+piles[i];
        return stoneGameII(piles,1,0);
    }

    public int stoneGameII(int[] piles,int M,int index){
        if(index==piles.length)
            return 0;

        int res=0;
        int cur =0;
        for(int i=index;i<Math.min(piles.length,index+2*M);i++){
            cur+=piles[i];
            int curX=(i-index+1);
            int nextM=Math.max(M,curX);
            if(map[nextM][i+1]==0)
                map[nextM][i+1]=stoneGameII(piles,nextM,i+1);
            res=Math.max(res,cur+sum[sum.length-1]-sum[i+1]-map[nextM][i+1]);
        }

        return res;
    }


    public static void main(String[] args){
        int[] t=new int[]{9,2,2,8,3,7,9,9};
        int[] t1=new int[]{1,1,1};
        Leetcode1140 cur=new Leetcode1140();
        System.out.println(cur.stoneGameII(t));
        System.out.println(Arrays.toString(cur.sum));
        System.out.println(cur.map);
    }
}
