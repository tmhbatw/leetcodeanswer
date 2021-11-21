package leetcode.leetcode17;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode1631 {

    public int minimumEffortPath(int[][] heights) {
        int row=heights.length,col=heights[0].length;

        int[][] res=new int[row][col];
        for(int[] cur:res)
            Arrays.fill(cur,Integer.MAX_VALUE);

        res[0][0]=0;
        PriorityQueue<int[]> q=new PriorityQueue<>((o1,o2)->{return o1[2]-o2[2];});

        q.add(new int[]{0,0,0});
        int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(res[cur[0]][cur[1]]<cur[2])
                continue;

            for(int[] next:nextPos){
                int i=next[0]+cur[0];
                int j=next[1]+cur[1];
                if(i<row&&i>=0&&j<col&&j>=0){
                    int curVal=Math.max(cur[2],Math.abs(heights[i][j]-heights[cur[0]][cur[1]]));
                    if(curVal<res[i][j]){
                        res[i][j]=curVal;
                        q.add(new int[]{i,j,curVal});
                    }
                }
            }
        }

        return res[row-1][col-1];
    }
}
