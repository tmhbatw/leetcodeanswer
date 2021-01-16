package leetcode3;

import java.util.Arrays;

public class Leetcode276 {
    /*Description
    * 有 k 种颜色的涂料和一个包含 n 个栅栏柱的栅栏，每个栅栏柱可以用其中一种颜色进行上色。
    * 你需要给所有栅栏柱上色，并且保证其中相邻的栅栏柱 最多连续两个颜色相同。然后，返回所有有效涂色的方案数。
    * 注意:
    * n 和k 均为非负的整数。
    * */

    public int numWays(int n, int k) {
        if(n==0)
            return 0;
        if(n==1)
            return k;
        int[] dp=new int[n+1];
        dp[0]=k;
        dp[1]=k*k;
        for(int i=2;i<n;i++){
            dp[i]=dp[i-1]*(k-1)+dp[i-2]*(k-1);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}
