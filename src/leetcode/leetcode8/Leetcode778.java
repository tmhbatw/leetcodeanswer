package leetcode.leetcode8;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode778 {

    public int swimInWater(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        int[][] res=new int[row][col];

        for(int[] cur:res){
            Arrays.fill(cur,Integer.MAX_VALUE);
        }
        res[0][0]=grid[0][0];
        PriorityQueue<int[]> q=new PriorityQueue<>((o1,o2)->o1[2]-o2[2]);

        q.add(new int[]{0,0,grid[0][0]});
        int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(res[cur[0]][cur[1]]<cur[2])
                continue;
            for(int[] next:nextPos){
                int i=next[0]+cur[0];
                int j=next[1]+cur[1];
                if(i>=0&&i<row&&j>=0&&j<col){
                    int val=Math.max(cur[2],grid[i][j]);
                    if(val<res[i][j]){
                        res[i][j]=val;
                        q.add(new int[]{i,j,val});
                    }
                }
            }
        }
        return res[row-1][col-1];
    }

}
