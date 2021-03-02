package forOffer;

import java.util.LinkedList;
import java.util.Queue;

public class forOffer13 {
    /*Description
    *地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
    * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，
    * 机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
    * */

    public int movingCount(int m, int n, int k) {
        boolean[][] reached=new boolean[m][n];
        Queue<int[]> q=new LinkedList<>();
        int res=0;
        int[][] pos=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        q.add(new int[]{0,0});
        reached[0][0]=true;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int val=getKVal(cur[0],cur[1]);
            if(val<=k){
                res++;
                for(int[] next:pos){
                    int ii=next[0]+cur[0];
                    int jj=next[1]+cur[1];
                    if(ii<m&&ii>=0&&jj<n&&jj>=0&&!reached[ii][jj]) {
                        reached[ii][jj]=true;
                        q.add(new int[]{ii, jj});
                    }
                }
            }
        }
        return res;
    }

    private int getKVal(int i,int j){
        int res=0;
        while(i>0){
            res+=i%10;
            i/=10;
        }
        while(j>0){
            res+=j%10;
            j/=10;
        }
        return res;
    }
}
