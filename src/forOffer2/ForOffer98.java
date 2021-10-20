package forOffer2;

public class ForOffer98 {
    public int uniquePaths(int m, int n) {
        int[][] res=new int[m+1][n+1];
        res[1][1]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                res[i][j]+=res[i-1][j]+res[i][j-1];
            }
        }
        return res[m][n];
    }
}
