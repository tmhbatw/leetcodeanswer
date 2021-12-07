package leetcode.leetcode7;

import java.util.HashSet;
import java.util.Set;

public class Leetcode694 {

    Set<String> set=new HashSet<>();
    int row;
    int col;
    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int numDistinctIslands(int[][] grid) {
        this.row=grid.length;
        this.col=grid[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    StringBuilder sb=new StringBuilder();
                    dfs(i,j,grid,sb);
                    set.add(sb.toString());
                }
            }
        }
        System.out.println(set);
        return set.size();
    }

    private void dfs(int i,int j,int[][] grid,StringBuilder sb){
        for(int index=0;index<4;index++){
            int ii=i+nextPos[index][0];
            int jj=j+nextPos[index][1];
            if(ii>=0&&ii<row&&jj>=0&&jj<col&&grid[ii][jj]==1) {
                grid[ii][jj]=0;
                sb.append(index);
                dfs(ii,jj,grid,sb);
            }
        }
        sb.append(" ");
    }
}
