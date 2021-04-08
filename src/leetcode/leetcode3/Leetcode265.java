package leetcode.leetcode3;

import java.util.Arrays;

public class Leetcode265 {
    /*Descripiton
    * 假如有一排房子，共 n 个，每个房子可以被粉刷成 k 种颜色中的一种，
    * 你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
    * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。
    * 每个房子粉刷成不同颜色的花费是以一个 n x k 的矩阵来表示的。
    * 例如，costs[0][0] 表示第 0 号房子粉刷成 0 号颜色的成本花费；costs[1][2]
    * 表示第 1 号房子粉刷成 2 号颜色的成本花费，以此类推。请你计算出粉刷完所有房子最少的花费成本。
    * */

    public int minCostII(int[][] costs) {
        if(costs==null||costs.length==0)
            return 0;
        int length=costs.length;
        int k=costs[0].length;
        int preMin=-1,preIndex=0,preSecond=-1;
        for(int i=0;i<k;i++){
            if(preMin==-1||costs[0][i]<=preMin){
                if(preMin<preSecond||preSecond==-1)
                    preSecond=preMin;
                preMin=costs[0][i];
                preIndex=i;
            }else if(preSecond==-1||costs[0][i]<=preSecond){
                preSecond=costs[0][i];
            }
        }
        for(int i=1;i<length;i++){
            int curMin=-1,curIndex=0,curSecond=-1;
            for(int j=0;j<k;j++){
                if(j==preIndex)
                    costs[i][j]+=preSecond;
                else
                    costs[i][j]+=preMin;
                if(curMin==-1||costs[0][i]<=curMin){
                    if(curMin<curSecond||curSecond==-1)
                        curSecond=curMin;
                    curMin=costs[i][j];
                    curIndex=j;
                }else if(curSecond==-1||costs[i][j]<=curSecond){
                    curSecond=costs[i][j];
                }
            }
            preMin=curMin;preIndex=curIndex;preSecond=curSecond;
        }
        for(int[] cur:costs)
            System.out.println(Arrays.toString(cur));
        int result=Integer.MAX_VALUE;
        for(int i=0;i<k;i++)
            result=Math.min(result,costs[length-1][i]);
        return result;
    }
}
