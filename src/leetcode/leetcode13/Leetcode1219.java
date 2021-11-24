package leetcode.leetcode13;

public class Leetcode1219 {

    int row,col;
    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    int result=0;
    public int getMaximumGold(int[][] grid) {
        this.row=grid.length;
        this.col=grid[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dfs(i,j,grid,0);
            }
        }

        return result;
    }

    private void dfs(int i, int j,int[][] grid,int sum){
        sum+=grid[i][j];
        if(grid[i][j]==0){
            result=Math.max(sum,result);
            return;
        }

        int cur=grid[i][j];
        grid[i][j]=0;
        for(int[] next:nextPos){
            int ii=i+next[0];
            int jj=j+next[1];
            if(ii>=0&&ii<row&&jj>=0&&jj<col){
                dfs(ii,jj,grid,sum);
            }
        }

        grid[i][j]=cur;
    }
}
