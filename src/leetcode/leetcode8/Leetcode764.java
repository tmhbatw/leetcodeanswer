package leetcode.leetcode8;

public class Leetcode764 {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp1=new int[n+2][n+2];
        int[][] dp2=new int[n+2][n+2];
        int[][] mine=new int[n][n];
        for(int[] m:mines)
            mine[m[0]][m[1]]=1;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mine[i][j]==0){
                    dp1[i+1][j+1]=dp1[i][j+1]+1;
                    dp2[i+1][j+1]=dp2[i+1][j]+1;
                }
            }
        }

        int result=0;
        int[][] dp3=new int[n+2][n+2];
        int[][] dp4=new int[n+2][n+2];
        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(mine[i][j]==0){
                    dp3[i+1][j+1]=dp3[i+1][j+2]+1;
                    dp4[i+1][j+1]=dp4[i+2][j+1]+1;
                    result=Math.max(result,Math.min(Math.min(dp1[i+1][j+1],
                            dp2[i+1][j+1]),Math.min(dp3[i+1][j+1],dp4[i+1][j+1])));
                }
            }
        }
        return result;
    }
}
