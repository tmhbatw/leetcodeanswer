package leetcode.leetcode18;

public class Leetcode1706 {

    public int[] findBall(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        int[] res=new int[col];
        for(int j=0;j<col;j++){
            int curJ=j;
            boolean success=true;
            for(int i=0;i<row;i++){
                if(grid[i][curJ]==1&&(curJ==col-1||grid[i][curJ+1]==-1)){
                    success = false;
                    break;
                }
                if(grid[i][curJ]==-1&&(curJ==0||grid[i][curJ-1]==1)){
                    success=false;
                    break;
                }
                curJ+=grid[i][curJ];
            }
            res[j]=success?curJ:-1;
        }
        return res;
    }
}
