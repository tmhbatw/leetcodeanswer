package leetcode.leetcode8;

public class Leetcode750 {

    public int countCornerRectangles(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        int[][] res=new int[col][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col-1;j++){
                for(int k=j+1;k<col;k++){
                    if(grid[i][j]==1&&grid[i][k]==1)
                        res[j][k]++;
                }
            }
        }
        int count=0;
        for(int i=0;i<col;i++){
            for(int j=i;j<col;j++){
                count+=(res[i][j]-1)*res[i][j]/2;
            }
        }
        return count;
    }
}
