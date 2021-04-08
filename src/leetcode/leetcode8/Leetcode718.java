package leetcode.leetcode8;

public class Leetcode718 {
    /*Description
    * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
    * */

    public int findLength(int[] A, int[] B) {
        int[][] dp=new int[A.length+1][B.length+1];
        int result=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(A[i]==B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    result=Math.max(result,dp[i+1][j+1]);
                }
            }
        }
        return result;
    }
}
