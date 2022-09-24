package leetcode.leetcode20;

public class Leetcode1922 {

    int mod=1000000007;
    public int countGoodNumbers(long n) {
        long time1=(n+1)/2;
        long time2=n/2;

        return (int) (getRes(time1,5)*getRes(time2,4)%mod);
    }

    private long getRes(long time,long cur){
        long result = 1;
        while(time>0){
            if(time%2==1){
                result=(result*cur)%mod;
            }
            cur=(cur*cur)%mod;
            time/=2;
        }
        return result;
    }


}
