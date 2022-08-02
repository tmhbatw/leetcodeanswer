package leetcode.leetcode17;

public class Leetcode1621 {

    public int numberOfSets(int n, int k) {
        n--;
        //到第i个点，包含j个线段的种类数量
        int[][] time=new int[n+1][k+1];
        int[][] sum=new int[n+1][k+1];
        int mod = 1000000007;
        time[0][0]=1;
        sum[0][0]=1;

        for(int i=1;i<=n;i++){
            time[i][0]=1;
            sum[i][0]=(sum[i-1][0]+1)%mod;
            for(int j=1;j<=k;j++){
                //这是没有用第j个节点组线段的情况
                time[i][j]=time[i-1][j];
                //time[i][j]=time[i][j]+time[0][j-1]~time[i-1][j-1]
                //sum[i-1][j-1]保存time[0][j-1]~time[i-1][j-1]的和
//                for(int m=0;m<i;m++){
//                    time[i][j]=(time[i][j]+time[m][j-1])%mod;
//                }
                time[i][j]=(time[i][j]+sum[i-1][j-1])%mod;
                sum[i][j]=(sum[i-1][j]+time[i][j])%mod;
            }
        }



        return time[n][k];
    }
}
