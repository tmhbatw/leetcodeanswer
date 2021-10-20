package forOffer2;

public class ForOffer99 {
    public int minPathSum(int[][] grid) {
        int[][] res=new int[grid.length+1][grid[0].length+1];
        for(int i=2;i<grid[0].length+1;i++)
            res[0][i]=Integer.MAX_VALUE;
        for(int j=1;j<grid.length+1;j++)
            res[j][0]=Integer.MAX_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                res[i+1][j+1]=Math.min(res[i][j+1],res[i+1][j])+grid[i][j];
            }
        }
        return res[grid.length][grid[0].length];
    }
}
