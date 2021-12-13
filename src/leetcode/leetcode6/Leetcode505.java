package leetcode.leetcode6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode505 {

    int[][] next=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int row=maze.length,col=maze[0].length;
        int[][] num=new int[row][col];
        for(int[] n:num)
            Arrays.fill(n,Integer.MAX_VALUE);
        num[start[0]][start[1]]=0;
        PriorityQueue<int[]> q=new PriorityQueue<>((o1,o2)->{
            return o1[2]-o2[2];
        });
        q.add(new int[]{start[0],start[1],0});

        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(num[cur[0]][cur[1]]<cur[2])
                continue;
            for(int[] n:next){
                int i=cur[0],j=cur[1];
                int val=cur[2];

                while(i+n[0]>=0&&i+n[0]<row&&j+n[1]>=0&&j+n[1]<col&&maze[i+n[0]][j+n[1]]==0){
                    i+=n[0];
                    j+=n[1];
                    val++;
                }
                if(num[i][j]>val) {
                    num[i][j]=val;
                    q.add(new int[]{i, j, val});
                }
            }
        }
        return num[destination[0]][destination[1]]==Integer.MAX_VALUE?-1:
                num[destination[0]][destination[1]];
    }
}
