package leetcode1;

import java.util.Arrays;

public class Leetcode72 {
    /*Description
    * 给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数。
    * 你可以对一个单词进行如下三种操作：
    * 插入一个字符
    * 删除一个字符
    * 替换一个字符
    * */

    public int minDistance(String word1, String word2) {
        int length1=word1.length(),length2=word2.length();
        int[][] dp=new int[length2+1][length1+1];
        for(int i=1;i<=length2;i++)
            dp[i][0]=i;
        for(int i=1;i<=length1;i++)
            dp[0][i]=i;
        for(int i=0;i<length2;i++){
            for(int j=0;j<length1;j++){
                if(word2.charAt(i)==word1.charAt(j))
                    dp[i+1][j+1]=dp[i][j];
                else{
                    dp[i+1][j+1]=Math.min(Math.min(dp[i][j],dp[i+1][j]),dp[i][j+1])+1;
                }
            }
        }
        return dp[length2][length1];
    }
}
