package leetcode6;

import java.util.Arrays;

public class Leetcode528 {
    /*Description
    * 给定一个正整数数组w ，其中w[i]代表下标 i的权重（下标从 0 开始），
    * 请写一个函数pickIndex，它可以随机地获取下标 i，选取下标 i的概率与w[i]成正比。
    * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3)= 0.25 （即，25%），
    * 而选取下标 1 的概率为 3 / (1 + 3)= 0.75（即，75%）。
    * 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
    * */

    class Solution {
        int[] dp;
        int sum=0;

        public Solution(int[] w) {
            dp=new int[w.length];
            for(int i=0;i<w.length;i++){
                sum+=w[i];
                if(i==0)
                    dp[i]=w[i];
                else
                    dp[i]=dp[i-1]+w[i];
            }
        }

        public int pickIndex() {
            int res=(int)(Math.random()*sum);
            int left=0,right=dp.length-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                System.out.println(mid);
                if(dp[mid]<=res)
                    left=mid+1;
                else if(mid==0||dp[mid-1]<=res)
                    return mid;
                else
                    right=mid-1;
            }
            return left;
        }
    }
}
