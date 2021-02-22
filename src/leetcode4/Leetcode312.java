package leetcode4;

import java.util.ArrayList;
import java.util.List;

public class Leetcode312 {
    /*Description
    * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组nums中。
    * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
    * 这里的 i - 1 和 i + 1 代表和i相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
    * 求所能获得硬币的最大数量。
    * */

    public int maxCoins(int[] nums) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        for(int cur:nums)
            list.add(cur);
        list.add(1);
        int number=nums.length;
        int[][] dp=new int[number+2][number+2];
        for(int i=0;i<number;i++)
            dp[i][i+2]=list.get(i)*list.get(i+1)*list.get(i+2);
        for(int length=3;length<number+2;length++){
            for(int i=0;i<number+2-length;i++){
                dp[i][i+length]=list.get(i+1)*list.get(i)*list.get(i+length)+dp[i+1][i+length];
                for(int j=i+2;j<i+length-1;j++){
                    dp[i][i+length]=Math.max(dp[i][i+length],list.get(j)*list.get(i)*list.get(i+length)
                        +dp[i][j]+dp[j][i+length]);
                }
                dp[i][i+length]=Math.max(dp[i][i+length],dp[i][i+length-1]+list.get(i+length-1)*list.get(i)
                        *list.get(i+length));
            }
        }
        return dp[0][number+1];
    }
}
