package leetcode.leetcode18;

import java.util.Arrays;

public class Leetcode1770 {

    public int maximumScore(int[] nums, int[] multipliers) {
        int n=nums.length,m=multipliers.length;
        int[][] max=new int[m+1][m+1];
        for(int i=0;i<m;i++){
            //取前0个到i个数，i个到0个后面的数
            max[i+1][0]=max[i][0]+multipliers[i]*nums[n-i-1];
            max[i+1][i+1]=max[i][i]+multipliers[i]*nums[i];

            for(int j=1;j<=i;j++){
                max[i+1][j]=Math.max(max[i][j-1]+multipliers[i]*nums[j-1],
                        max[i][j]+multipliers[i]*nums[n-(i-j)-1]);
            }
        }

        return Arrays.stream(max[m]).max().getAsInt();

    }

}
