package leetcode.leetcode8;

import java.util.Arrays;

public class Leetcode712 {
    /*Description
    * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
    * */

    public int minimumDeleteSum(String s1, String s2) {
        int length1=s1.length(),length2=s2.length();
        int[][] dp=new int[length1+1][length2+1];
        for(int i=0;i<length1;i++)
            dp[i+1][0]=dp[i][0]+s1.charAt(i);
        for(int j=0;j<length2;j++)
            dp[0][j+1]=dp[0][j]+s2.charAt(j);
        for(int i=0;i<length1;i++){
            for(int j=0;j<length2;j++){
                if(s1.charAt(i)==s2.charAt(j))
                    dp[i+1][j+1]=dp[i][j];
                else{
                    dp[i+1][j+1]=Math.min(s1.charAt(i)+dp[i][j+1],s2.charAt(j)+dp[i+1][j]);
                }
            }
        }
        for(int[] cur:dp)
            System.out.println(Arrays.toString(cur));
        return dp[length1][length2];
    }
}
