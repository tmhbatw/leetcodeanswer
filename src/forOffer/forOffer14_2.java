package forOffer;

public class forOffer14_2 {
    /*Description
    * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
    * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
    * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
    * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
    * */


    public int cuttingRope(int n) {
        if(n<=3)
            return n-1;
        int mod=1000000007;
        int left=n-(n-3)/3*3;
        long res=1;
        for(int i=0;i<=n-6;i+=3){
            res=res*3%mod;
        }
        if(n%3==0) {
            return (int)(res * 3%mod);
        }
        if(n%3==1)
            return (int)(res*4%mod);
        return (int)(res*6%mod);

    }
}
