package leetcode.leetcode11;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1091 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==0)
            return -1;

        int row=grid.length,col=grid[0].length;
        if(row==1&&col==1)
            return 1;
        int[][] nextPos=new int[][]{{-1,0},{-1,-1},{-1,1},{0,1},{0,-1},
                {1,0},{1,1},{1,-1}};

        boolean[][] reached=new boolean[row][col];
        reached[0][0]=true;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0});
        int distance=1;

        while(!q.isEmpty()){
            distance++;
            int size=q.size();
            while(size-->0){
                int[] cur=q.poll();
                for(int[] next:nextPos){
                    int ii=cur[0]+next[0];
                    int jj=cur[1]+next[1];
                    if(ii>=0&&ii<row&&jj>=0&&jj<col&&!
                            reached[ii][jj]&&grid[ii][jj]==0){
                        if(ii==row-1&&jj==col-1)
                            return distance;
                        reached[ii][jj]=true;
                        q.add(new int[]{ii,jj});
                    }
                }
            }
        }
        return -1;
    }

}
