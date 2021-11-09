package leetcode.leetcode10;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode994 {

    public int orangesRotting(int[][] grid) {
        int count=0;
        Queue<int[]> q=new LinkedList<>();

        int row=grid.length,col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2)
                    q.add(new int[]{i,j});
                if(grid[i][j]==1)
                    count++;
            }
        }

        if(count==0)
            return 0;

        int distance=0;
        int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()&&count!=0){
            distance++;
            int size=q.size();
            while(size-->0){
                int[] cur=q.poll();
                for(int[] next:nextPos){
                    int ii=cur[0]+next[0];
                    int jj=cur[1]+next[1];
                    if(ii>=0&&ii<row&&jj>=0&&jj<col&&grid[ii][jj]==1){
                        count--;
                        if(count==0)
                            return distance;
                        grid[ii][jj]=2;
                        q.add(new int[]{ii,jj});
                    }
                }
            }
        }

        return -1;
    }
}
