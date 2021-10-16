package leetcode.leetcode17;

import java.util.Arrays;

public class Leetcode1646 {

    public int getMaximumGenerated(int n) {
        int[] res=new int[Math.max(3,n+1)];
        res[1]=0;
        res[2]=1;
        for(int i=2;i<=n;i++){
            if(i%2==0)
                res[i]=res[i/2];
            else
                res[i]=res[i/2]+res[i/2+1];
        }
        int max=0;
        for(int i=0;i<=n;i++)
            max=Math.max(max,res[i]);
        return max;
    }
}
