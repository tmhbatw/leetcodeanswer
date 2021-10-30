package leetcode.leetcode9;

public class Leetcode861 {

    public int matrixScore(int[][] grid) {
        for(int[] cur:grid){
            if(cur[0]==0)
                reverse(cur);
        }
        int result=0;
        int base=1;
        for(int j=grid[0].length-1;j>=0;j--){
            int curCount=0;
            for(int i=0;i<grid.length;i++){
                if(grid[i][j]==1)
                    curCount++;
            }
            result+=Math.max(curCount,grid.length-curCount)*base;
            base*=2;
        }
        return result;
    }

    private void reverse(int[] cur){
        for(int i=0;i<cur.length;i++)
            cur[i]=1-cur[i];
    }


}
