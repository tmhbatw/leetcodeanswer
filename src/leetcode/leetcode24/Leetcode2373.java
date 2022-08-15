package leetcode.leetcode24;

public class Leetcode2373 {

    public int[][] largestLocal(int[][] grid) {
        int[][] res=new int[grid.length-2][grid[0].length];
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                int result = grid[i][j];
                for(int ii=-1;ii<=1;ii++){
                    for(int jj=-1;jj<=1;jj++){
                        result=Math.max(result,grid[i+ii][j+jj]);
                    }
                }

                res[i-1][j-1]=result;
            }
        }

        return res;
    }
}
