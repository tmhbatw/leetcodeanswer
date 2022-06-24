package leetcode.leetcode24;

import java.util.Arrays;

public class Leetcode2304 {

    //每一个格子表示的数值是从第一行到当前行的最小值
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m=grid.length,n=grid[0].length;
        int[][] result=new int[m][n];

        for(int i=0;i<m-1;i++){

            Arrays.fill(result[i+1],Integer.MAX_VALUE);

            for(int j=0;j<n;j++){

                int[] mCost = moveCost[grid[i][j]];
                for(int k =0;k<n;k++){
                    result[i+1][k]=Math.min(result[i+1][k],result[i][j]+mCost[k]+grid[i][j]);
                }

            }
        }

        int res=Integer.MAX_VALUE;
        for(int j=0;j<n;j++)
            res=Math.min(res,result[m-1][j]+grid[m-1][j]);

        return res;
    }

    public static void main(String[] args){
        System.out.println("hello world!");
        System.out.println("我是刘芮洪！");
    }
}
