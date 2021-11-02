package leetcode.leetcode10;

public class Leetcode980 {

    int[][] next=new int[][]{{-1,0},{0,1},{0,-1},{1,0}};
    int row;
    int col;
    int result=0;
    public int uniquePathsIII(int[][] grid) {
        this.row=grid.length;
        this.col=grid[0].length;
        int[] start=getStart(grid);
        int i=start[0],j=start[1];
        boolean[][] reached=new boolean[row][col];
        reached[i][j]=true;
        dfs(i,j,grid,reached);
        return result;
    }
    private int[] getStart(int[][] grid){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1)
                    return new int[]{i,j};
            }
        }
        return new int[]{0,0};
    }

    private void dfs(int i,int j,int[][] grid,boolean[][] reached){
        if(grid[i][j]==2){
            if(isValid(reached,grid)){
                result++;
            }
            return ;
        }
        for(int[] next:next){
            int ii=next[0]+i,jj=next[1]+j;
            if(ii<row&&ii>=0&&jj<col&&jj>=0&&!reached[ii][jj]&&grid[ii][jj]>0){
                reached[ii][jj]=true;
                dfs(ii,jj,grid,reached);
                reached[ii][jj]=false;
            }
        }
    }

    private boolean isValid(boolean[][] reached,int[][] grid){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]!=-1&&!reached[i][j])
                    return false;
            }
        }
        return true;
    }
}
