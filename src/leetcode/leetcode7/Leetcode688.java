package leetcode.leetcode7;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode688 {

    int[][] nextPos=new int[][]{{1,2},{2,1},{-1,2},{-2,1},{1,-2},{2,-1},{-1,-2},{-2,-1}};
    public double knightProbability(int n, int k, int row, int column) {
        Queue<int[]> pos=new LinkedList<>();
        Queue<Double> q=new LinkedList<>();

        pos.add(new int[]{row,column});
        q.add(1.0);

        double result=0;
        while(!pos.isEmpty()&&k-->0){
            int size=pos.size();
            double[][] dp=new double[n][n];
            while (size-- > 0) {
                int[] cur=pos.poll();
                double curQ=q.poll()/8;
                for(int[] next:nextPos){
                    int i=next[0]+cur[0];
                    int j=next[1]+cur[1];
                    if(i<0||i>=n||j<0||j>=n)
                        result+=curQ;
                    else {
                        dp[i][j]+=curQ;
                    }
                }
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dp[i][j]>0){
                        pos.add(new int[]{i,j});
                        q.add(dp[i][j]);
                    }
                }
            }
        }
        return 1-result;
    }
}
