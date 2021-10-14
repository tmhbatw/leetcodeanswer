package leetcode.leetcode9;

public class Leetcode892 {

    int[][] next=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int surfaceArea(int[][] grid) {
        int result=0;
        int row=grid.length,col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                for(int[] n:next){
                    int ii=i+n[0];
                    int jj=j+n[1];
                    if(ii>=0&&ii<row&&jj>=0&&jj<col){
                        result+=Math.max(grid[i][j]-grid[ii][jj],0);
                    }else
                        result+=grid[i][j];
                }
                if(grid[i][j]>0)
                    result+=2;
            }
        }
        return result;
    }
}
