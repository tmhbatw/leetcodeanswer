package leetcode.leetcode4;

public class Leetcode370 {
    /*Description
    * 假设你有一个长度为n的数组，初始情况下所有的数字均为0，
    * 你将会被给出k 个更新的操作。
    * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组
    * A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加inc。
    * 请你返回k次操作后的数组。
    * */

    public int[] getModifiedArray(int length, int[][] updates) {
        int [] dp=new int[length];
        for(int[] cur:updates){
            dp[cur[0]]+=cur[2];
            if(cur[1]!=length-1)
            dp[cur[1]+1]-=cur[2];
        }
        for(int i=1;i<length;i++){
            dp[i]+=dp[i-1];
        }
        return dp;
    }
}
