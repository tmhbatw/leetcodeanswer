package leetcode.leetcode5;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode490 {

    int[][] next=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int row=maze.length,col=maze[0].length;
        boolean[][] reached=new boolean[row][col];
        reached[start[0]][start[1]]=true;
        Queue<int[]> q=new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int[] n:next){
                int i=cur[0],j=cur[1];
                while(i+n[0]>=0&&i+n[0]<row&&j+n[1]>=0&&j+n[1]<col&&maze[i+n[0]][j+n[1]]==0){
                    i+=n[0];
                    j+=n[1];
                }
                if(i==destination[0]&&j==destination[1])
                    return true;
                if(!reached[i][j]) {
                    q.add(new int[]{i, j});
                    reached[i][j]=true;
                }
            }
        }
        return false;
    }
}
