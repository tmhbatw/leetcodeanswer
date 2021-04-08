package leetcode.leetcode2;

public class Leetcode174 {
    /*Description
    * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。
    * 我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
    * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
    * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；
    * 其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
    * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
    * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数.
    * */

    /*Solution
    * 可以使用动态规划，需要注意的是可以从右下角到左上角遍历，每个点保留从该店到达终点所需要的最小的值
    * */

    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0||dungeon[0].length==0)
            return 1;
        int row=dungeon.length,col=dungeon[0].length;
        dungeon[row-1][col-1]=Math.max(0,-dungeon[row-1][col-1])+1;
        for(int i=row-2;i>=0;i--){
            dungeon[i][col-1]=Math.max(dungeon[i+1][col-1]-dungeon[i][col-1],1);
        }
        for(int j=col-2;j>=0;j--){
            dungeon[row-1][j]=Math.max(dungeon[row-1][j+1]-dungeon[row-1][j],1);
        }
        for(int i=row-2;i>=0;i--){
            for(int j=col-2;j>=0;j--){
                dungeon[i][j]=Math.max(Math.min(dungeon[i+1][j],dungeon[i][j+1])-dungeon[i][j],1);
            }
        }
        return dungeon[0][0];
    }
}
