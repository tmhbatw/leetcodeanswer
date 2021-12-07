package leetcode.leetcode18;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1765 {

    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int[][] highestPeak(int[][] isWater) {
        Queue<int[]> q=new LinkedList<>();
        int row=isWater.length,col=isWater[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(isWater[i][j]==1){
                    q.add(new int[]{i,j});
                }
            }
        }

        int[][] result=new int[row][col];
        int distance=1;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int[] cur=q.poll();
                for(int[] next:nextPos){
                    int i=next[0]+cur[0];
                    int j=next[1]+cur[1];
                    if(i>=0&&i<row&&j>=0&&j<col&&isWater[i][j]==0){
                        result[i][j]=distance;
                        isWater[i][j]=1;
                        q.add(new int[]{i,j});
                    }
                }
            }
            distance++;
        }
        return result;
    }
}
