package leetcode.leetcode19;

public class Leetcode1893 {

    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] dp=new int[52];
        for(int[] range:ranges){
            dp[range[0]]++;
            dp[range[1]+1]--;
        }
        for(int i=1;i<=51;i++)
            dp[i]+=dp[i-1];

        for(int i=left;i<=right;i++){
            if(dp[i]==0)
                return false;
        }
        return true;
    }

}
