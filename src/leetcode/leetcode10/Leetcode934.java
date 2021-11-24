package leetcode.leetcode10;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode934 {

    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int shortestBridge(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    boolean[][] reached=new boolean[row][col];
                    reached[i][j]=true;

                    Queue<int[]> q=new LinkedList<>();
                    Queue<int[]> qq=new LinkedList<>();

                    q.add(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        qq.add(cur);
                        for(int[] next:nextPos){
                            int ii=next[0]+cur[0];
                            int jj=next[1]+cur[1];
                            if(ii>=0&&ii<row&&jj>=0&&jj<col&&
                                    !reached[ii][jj]&&grid[ii][jj]==1){
                                reached[ii][jj]=true;
                                q.add(new int[]{ii,jj});
                            }
                        }
                    }

                    int result=0;
                    while(!qq.isEmpty()){
                        int size=qq.size();
                        while(size-->0){
                            int[] cur=qq.poll();
                            for(int[] next:nextPos){
                                int ii=cur[0]+next[0];
                                int jj=cur[1]+next[1];
                                if(ii>=0&&ii<row&&jj>=0&&jj<col&&
                                    !reached[ii][jj]){
                                    if(grid[ii][jj]==0){
                                        reached[ii][jj]=true;
                                        qq.add(new int[]{ii,jj});
                                    }else{
                                        return result;
                                    }
                                }
                            }
                        }
                        result++;
                    }
                }
            }
        }
        return -1;
    }
}
