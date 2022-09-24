package leetcode.leetcode16;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1559 {

    int m,n;
    boolean[][]reached;
    boolean result=false;
    int[][] next=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public boolean containsCycle(char[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        this.reached=new boolean[m][n];

        boolean[][] r=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(r[i][j])
                    continue;
                dfs(i,j,-1,-1,grid);
                if(result)
                    return true;
                Queue<int[]> q=new LinkedList<>();
                q.add(new int[]{i,j});
                while(!q.isEmpty()){
                    int[] cur=q.poll();
                    for(int[] p:next){
                        int ii=p[0]+cur[0];
                        int jj=p[1]+cur[1];
                        if(ii>=0&&ii<m&&jj>=0&&jj<n&&grid[ii][jj]==grid[i][j]&&!r[ii][jj]){
                            r[ii][jj]=true;
                            q.add(new int[]{ii,jj});
                        }
                    }
                }
            }
        }
        return false;
    }

    private void dfs(int i,int j,int prei,int prej,char[][] grid){
        if(result)
            return;
        reached[i][j]=true;
        for(int[] p:next){
            int ii=p[0]+i;
            int jj=p[1]+j;
            if(ii>=0&&ii<m&&jj>=0&&jj<n&&grid[ii][jj]==grid[i][j]&&(ii!=prei||jj!=prej)){
                if(reached[ii][jj]){
                    result=true;
                    return;
                }
                dfs(ii,jj,i,j,grid);
            }
        }
        reached[i][j]=false;
    }

}
