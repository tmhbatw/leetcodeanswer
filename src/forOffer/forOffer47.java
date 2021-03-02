package forOffer;

public class forOffer47 {
    /*Description
    * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）
    * 。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
    * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
    * */

    public int maxValue(int[][] grid) {
        if(grid.length==0)
            return 0;
        int row=grid.length,col=grid[0].length;
        int[][] max=new int[row+1][col+1];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                max[i+1][j+1]=Math.max(max[i+1][j],max[i][j+1])+grid[i][j];
            }
        }
        return max[row][col];
    }
}
