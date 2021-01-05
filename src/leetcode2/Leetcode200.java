package leetcode2;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode200 {
    /*Description
    * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
    * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
    * 此外，你可以假设该网格的四条边均被水包围。
    * */

    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        int result=0;
        int row=grid.length,col=grid[0].length;
        int[][] pos=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        boolean[][] reached=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'&&!reached[i][j]){
                    result++;
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    reached[i][j]=true;
                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        for(int[] nextPos:pos){
                            int ii=cur[0]+nextPos[0];
                            int jj=cur[1]+nextPos[1];
                            if(ii<row&&ii>=0&&jj<col&&jj>=0&&!reached[ii][jj]&&grid[ii][jj]=='1'){
                                reached[ii][jj]=true;
                                q.add(new int[]{ii,jj});
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
