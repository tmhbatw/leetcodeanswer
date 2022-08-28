package leetcode.leetcode20;

import java.util.Arrays;

public class Leetcode1959 {

    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n=nums.length;
        int[][] waste=new int[k+1][n+1];

        int max=0;
        int sum=0;
        for(int j=0;j<nums.length;j++){
            max=Math.max(nums[j],max);
            sum+=nums[j];
            waste[0][j+1]=max*(j+1)-sum;
        }

        for(int i=0;i<k;i++){
            for(int j=0;j<nums.length;j++){
                int min = waste[i][j];
                int m=0;
                int s=0;
                //可以前k个数浪费i-1次，后k+1到j个数浪费一次，求最小的情况
                for(int x=j-1;x>=0;x--){
                    int cur = waste[i][x+1];
                    m=Math.max(m,nums[x+1]);
                    s+=nums[x+1];
                    cur+=m*(j-x)-s;
                    min=Math.min(min,cur);
                }
                waste[i+1][j+1]=min;
            }
        }
        return waste[k][n];
    }

}
