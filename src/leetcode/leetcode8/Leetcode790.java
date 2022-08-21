package leetcode.leetcode8;

public class Leetcode790 {

    public int numTilings(int n) {
        long[] res=new long[n+1];
        res[0]=1;
        int mod=1000000007;
        for(int i=1;i<res.length;i++){
            for(int j=1;j<=i;j++){
                if(j<=2)
                    res[i]+=res[i-j];
                else
                    res[i]+=res[i-j]*2;
            }
            res[i]%=mod;
        }


        return (int)res[n];
    }

}
