package leetcode.leetcode11;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1034 {

    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int preColor=grid[row][col];
        if(preColor==color)
            return grid;
        Queue<int[]> q=new LinkedList<>();
        grid[row][col]=color;
        q.add(new int[]{row,col});

        int m=grid.length,n=grid[0].length;
        boolean[][] reached=new boolean[m][n];
        reached[row][col]=true;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int[] next:nextPos){
                int ii=cur[0]+next[0];
                int jj=cur[1]+next[1];
                if(ii<m&&ii>=0&&jj<n&&jj>=0&&grid[ii][jj]==preColor){
                    grid[ii][jj]=color;
                    reached[ii][jj]=true;
                    q.add(new int[]{ii,jj});
                }
            }
        }

        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(reached[i][j]&&reached[i-1][j]&&reached[i+1][j]&&reached[i][j-1]
                &&reached[i][j+1]) {
                    grid[i][j] = preColor;
                }
            }
        }

        return grid;
    }
}
