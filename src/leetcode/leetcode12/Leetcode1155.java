package leetcode.leetcode12;

public class Leetcode1155 {

    public int numRollsToTarget(int n, int k, int target) {
        int mod = 1000000007;
        //当前的值为i的情况数量
        int[] time=new int[target+1];
        time[0]=1;

        for(int i=0;i<n;i++){

            int[] cur=new int[target+1];
            //第i次投掷的点数为k
            for(int j=1;j<=k;j++){
                for(int m=j;m<=target;m++){
                    cur[m] = (cur[m]+time[m-j])%mod;
                }
            }
            time=cur;
        }

        return time[target];
    }

}
