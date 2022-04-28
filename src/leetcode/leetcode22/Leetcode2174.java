package leetcode.leetcode22;

public class Leetcode2174 {
    int result= Integer.MAX_VALUE;
    int m;
    int n;
    boolean[] reachedM;
    boolean[] reachedN;

    public int removeOnes(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        this.reachedM = new boolean[m];
        this.reachedN = new boolean[n];
        dfs(0,grid,0);
        return result;
    }

    private void dfs(int i,int[][] grid,int time){
        if(time>=result)
            return;

        if(i==m*n){
            if(match(grid)){

                result=Math.min(result,time);
            }
            return;
        }
        dfs(i+1,grid,time);
        int ii=i/n,jj=i%n;
        if(!reachedM[ii]&&!reachedN[jj]&&grid[ii][jj]==1){
            reachedM[ii]=true;
            reachedN[jj]=true;
            dfs(i+1,grid,time+1);
            reachedM[ii]=false;
            reachedN[jj]=false;
        }
    }

    private boolean match(int[][] grid){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    if(!reachedM[i]&&!reachedN[j])
                        return false;
                }
            }
        }
        return true;
    }
}
