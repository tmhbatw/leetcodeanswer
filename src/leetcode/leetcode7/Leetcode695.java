package leetcode.leetcode7;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode695 {
    /*Description
    * 给定一个包含了一些 0 和 1 的非空二维数组grid 。
    * 一个岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
    * 你可以假设grid 的四个边缘都被 0（代表水）包围着。找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
    * */

    public int maxAreaOfIsland(int[][] grid) {
        int result=0;
        if(grid.length==0||grid[0].length==0)
            return result;
        int row=grid.length,col=grid[0].length;
        boolean[][] reached=new boolean[row][col];
        int[][] pos=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(!reached[i][j]&&grid[i][j]==1){
                    reached[i][j]=true;
                    int cur=1;
                    Queue<Point> q=new LinkedList<>();
                    q.add(new Point(i,j));
                    while(!q.isEmpty()){
                        Point curPoint=q.poll();
                        for(int[] next:pos){
                            int ii=curPoint.x+next[0];
                            int jj=curPoint.y+next[1];
                            if(ii>=0&&ii<row&&jj>=0&&jj<col&&!reached[ii][jj]&&grid[ii][jj]==1){
                                reached[ii][jj]=true;
                                cur++;
                                q.add(new Point(ii,jj));
                            }
                        }
                    }
                    result=Math.max(result,cur);
                }
            }
        }
        return result;
    }

    private class Point{
        int x,y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}
