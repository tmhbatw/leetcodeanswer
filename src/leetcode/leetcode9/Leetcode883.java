package leetcode.leetcode9;

public class Leetcode883 {

    public int projectionArea(int[][] grid) {
        int result=0;
        int row=grid.length,col=grid[0].length;
        for(int i=0;i<row;i++){
            int cur=0;
            for(int j=0;j<col;j++){
                cur=Math.max(cur,grid[i][j]);
                if(grid[i][j]>0)
                    result++;
            }
            result+=cur;
        }

        for(int j=0;j<col;j++){
            int cur=0;
            for(int i=0;i<row;i++){
                cur=Math.max(cur,grid[i][j]);
            }
            result+=cur;
        }
        return result;
    }
}
