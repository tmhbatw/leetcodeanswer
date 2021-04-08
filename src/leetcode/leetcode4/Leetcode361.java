package leetcode.leetcode4;

public class Leetcode361 {
    /*Description
    * 想象一下炸弹人游戏，在你面前有一个二维的网格来表示地图，网格中的格子分别被以下三种符号占据：
    * 'W'表示一堵墙
    * 'E'表示一个敌人
    * '0'（数字 0）表示一个空位
    * 请你计算一个炸弹最多能炸多少敌人。
    * 由于炸弹的威力不足以穿透墙体，炸弹只能炸到同一行和同一列没被墙体挡住的敌人。
    * 注意：你只能把炸弹放在一个空的格子里
    * */

    public int maxKilledEnemies(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)
            return 0;
        int row=grid.length,col=grid[0].length;
        int result=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='0'){
                    int curRes=0;
                    int ii=i-1;
                    while(ii>=0&&grid[ii][j]!='W'){
                        if(grid[ii][j]=='E')
                            curRes++;
                        ii--;
                    }
                    ii=i+1;
                    while(ii<row&&grid[ii][j]!='W'){
                        if(grid[ii][j]=='E')
                            curRes++;
                        ii++;
                    }
                    int jj=j-1;
                    while(jj>=0&&grid[i][jj]!='W'){
                        if(grid[i][jj]=='E')
                            curRes++;
                        jj--;
                    }
                    jj=j+1;
                    while(jj<col&&grid[i][jj]!='W'){
                        if(grid[i][jj]=='E')
                            curRes++;
                        jj++;
                    }
                    result=Math.max(result,curRes);
                }
            }
        }
        return result;
    }
}
