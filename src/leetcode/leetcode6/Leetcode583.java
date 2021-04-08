package leetcode.leetcode6;

import java.util.Arrays;

public class Leetcode583 {
    /*Description
    * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
     * */

    public int minDistance(String word1, String word2) {
        int length1=word1.length(),length2=word2.length();
        int[][] dp=new int[length1+1][length2+1];
        for(int i=0;i<length1;i++){
            dp[i+1][0]=i+1;
        }
        for(int j=0;j<length2;j++){
            dp[0][j+1]=j+1;
        }
        for(int i=0;i<length1;i++){
            for(int j=0;j<length2;j++){
                if(word1.charAt(i)==word2.charAt(j))
                    dp[i+1][j+1]=dp[i][j];
                else
                    dp[i+1][j+1]=Math.min(dp[i+1][j],dp[i][j+1])+1;
            }
        }
        for(int[] cur:dp)
            System.out.println(Arrays.toString(cur));
        return dp[length1][length2];
    }

}
