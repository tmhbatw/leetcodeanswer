package leetcode.leetcode12;

public class Leetcode1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int l1=text1.length(),l2=text2.length();
        int[][] dp=new int[l1+1][l2+1];

        for(int i=0;i<l1;i++){
            for(int j=0;j<l2;j++){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i+1][j+1]=dp[i][j]+1;
                }else
                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
            }
        }
        return dp[l1][l2];
    }
}
