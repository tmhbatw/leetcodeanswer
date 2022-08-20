package leetcode.leetcode12;

public class Leetcode1139 {

    public int largest1BorderedSquare(int[][] grid) {
        int row =grid.length,col=grid[0].length;
        int[][] sum=new int[row+1][col+1];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                sum[i+1][j+1]=sum[i][j+1]+sum[i+1][j]-sum[i][j]+grid[i][j];
            }
        }

        int result=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                for(int k=result;k<Math.min(row-i,col-j);k++){
                    int cur = getSum(sum,i,j,k)-getSum(sum,i+1,j+1,k-2);
                    if(cur == getEdge(k)){
                        result=k+1;
                    }
                }
            }
        }

        return result*result;
    }

    private int getEdge(int k){
        if(k==0)
            return 1;
        return k*4;
    }

    private int getSum(int[][] sum,int i,int j,int k){
        if(k<0)
            return 0;
        return sum[i+k+1][j+k+1]-sum[i][j+k+1]-sum[i+k+1][j]+sum[i][j];
    }


}
