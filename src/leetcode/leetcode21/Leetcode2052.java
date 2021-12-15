package leetcode.leetcode21;

import java.util.Arrays;

public class Leetcode2052 {

    public int minimumCost(String sentence, int k) {
        String[] s=sentence.split(" ");
        int[] num=new int[s.length];

        for(int i=0;i<s.length;i++){
            num[i]=s[i].length();
        }

        int length=num.length;
        int[] dp=new int[length+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for(int i=0;i<length;i++){
            int j=i;
            int sum=-1;

            while(j<length&&sum+1+num[j]<=k){
                sum+=1+num[j];
                if(j==length-1)
                    dp[j+1]=Math.min(dp[j+1],dp[i]);
                else
                    dp[j+1]=Math.min(dp[j+1],dp[i]+(k-sum)*(k-sum));

                j++;
            }
        }

        return dp[length];
    }
}
