package leetcode3;

public class Leetcode256 {
    /*Description
    * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，
    * 你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
    * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。
    * 每个房子粉刷成不同颜色的花费是以一个n x 3的矩阵来表示的。
    * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2]表示第 1 号房子粉刷成绿色的花费，
    * 以此类推。请你计算出粉刷完所有房子最少的花费成本。
    * */

    public int minCost(int[][] costs) {
        if(costs==null||costs.length==0)
            return 0;
        int length=costs.length;
        for(int i=1;i<length;i++){
            costs[i][0]+=Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1]+=Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2]+=Math.min(costs[i-1][0],costs[i-1][1]);
        }
        return Math.min(Math.min(costs[length-1][0],costs[length-1][1]),costs[length-1][2]);
    }
}
