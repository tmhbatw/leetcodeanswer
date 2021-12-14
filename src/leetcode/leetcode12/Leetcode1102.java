package leetcode.leetcode12;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode1102 {

    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int maximumMinimumPath(int[][] grid) {
        int row=grid.length,col=grid[0].length;

        int[][] num=new int[row][col];
        num[0][0]=grid[0][0];

        PriorityQueue<int[]> q=new PriorityQueue<>((o1,o2)->{
            return o2[2]-o1[2];
        });
        q.add(new int[]{0,0,grid[0][0]});
        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(cur[2]<num[cur[0]][cur[1]])
                continue;
            for(int[] n:nextPos){
                int i=cur[0]+n[0],j=cur[1]+n[1];
                if(i>=0&&i<row&&j>=0&&j<col){
                    int val=Math.min(cur[2],grid[i][j]);
                    if(val>num[i][j]){
                        num[i][j]=val;
                        q.add(new int[]{i,j,val});
                    }
                }
            }
        }
        return num[row-1][col-1];
    }
}
