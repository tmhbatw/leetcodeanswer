package leetcode.leetcode14;

public class Leetcode1351 {

    public int countNegatives(int[][] grid) {
        int count=0;
        int row=grid.length;
        int col=grid[0].length;
        int j=0;
        for(int i=row-1;i>=0;i--){
            while(j<col&&grid[i][j]>=0)
                j++;
            count+=col-j;
        }
        return count;
    }
}
