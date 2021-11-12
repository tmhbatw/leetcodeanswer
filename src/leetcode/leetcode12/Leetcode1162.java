package leetcode.leetcode12;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1162 {

    public int maxDistance(int[][] grid) {
        int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        Queue<int[]> q=new LinkedList<>();
        int row=grid.length,col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j});
                }
            }
        }

        if(q.size()==row*col)
            return 0;

        int distance=-1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int[] cur=q.poll();
                for(int[] next:nextPos){
                    int i=cur[0]+next[0];
                    int j=cur[1]+next[1];
                    if(i>=0&&i<row&&j>=0&&j<col&&grid[i][j]==0){
                        grid[i][j]=1;
                        q.add(new int[]{i,j});
                    }
                }
            }
            distance++;
        }
        return distance;
    }
}
