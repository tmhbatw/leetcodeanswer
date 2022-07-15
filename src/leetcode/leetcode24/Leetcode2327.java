package leetcode.leetcode24;

public class Leetcode2327 {

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        //数组用来表示今天新知道这个秘密的人
        int[] cur=new int[n];
        cur[0]=1;
        int mod=1000000007;
        for(int i=0;i<n;i++){
            for(int j=i+delay;j<Math.min(n,i+forget);j++)
                cur[j]=(cur[j]+cur[i])%mod;
        }

        int result = 0;
        for(int i =Math.max(0,n-forget);i<n;i++)
            result=(result+cur[i])%mod;

        return result;
    }

}
