package leetcode.leetcode9;

import java.util.Arrays;

public class Leetcode807 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int result=0;
        int[] row=new int[grid.length];
        int[] col=new int[grid[0].length];

        for(int j=0;j<grid.length;j++){
            for(int i=0;i<grid.length;i++){
                row[i]=Math.max(row[i],grid[i][j]);
                col[j]=Math.max(col[j],grid[i][j]);
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                result+=Math.min(row[i],col[j])-grid[i][j];
            }
        }

        return result;
    }
}
