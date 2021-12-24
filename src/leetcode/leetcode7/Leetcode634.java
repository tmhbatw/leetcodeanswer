package leetcode.leetcode7;

public class Leetcode634 {
    int mod=1000000007;
    public int findDerangement(int n) {
        if(n==1)
            return 0;
        int[] res=new int[n+1];
        res[1]=0;
        res[2]=1;

        for(int i=3;i<=n;i++){
            long cur= (long) (i - 1) *(res[i-1]+res[i-2])%mod;
            res[i]= (int) cur;
        }
        return res[n];
    }

/*
*
*        0,0,1,2,9,44,265
    //   0,1,2,3,4,5,6
    //      0,1,1,3,11,53
*
*   比如对于n=7来说，相当于6*(把2到7的数放在1到6这个坑坑里)
*  */


    //
}
