package leetcode.leetcode20;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1905 {

    int[][] next=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m=grid1.length,n=grid1[0].length;
        int[][] type=new int[m][n];
        int index=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid1[i][j]==1&&type[i][j]==0){
                    index++;
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    type[i][j]=index;

                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        for(int[] nextPos:next){
                            int ii=cur[0]+nextPos[0];
                            int jj=cur[1]+nextPos[1];
                            if(ii>=0&&ii<m&&jj>=0&&jj<n&&grid1[ii][jj]==1&&type[ii][jj]==0){
                                type[ii][jj]=index;
                                q.add(new int[]{ii,jj});
                            }
                        }
                    }
                }
            }
        }


        int count = 0;
        boolean[][] reached=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1&&!reached[i][j]){
                    int t=type[i][j];
                    boolean add=true;
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    reached[i][j]=true;
                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        for(int[] nextPos:next){
                            int ii=nextPos[0]+cur[0];
                            int jj=nextPos[1]+cur[1];
                            if(ii>=0&&ii<m&&jj>=0&&jj<n&&!reached[ii][jj]&&grid2[ii][jj]==1){
                                if(type[ii][jj]!=t)
                                    add=false;
                                reached[ii][jj]=true;
                                q.add(new int[]{ii,jj});
                            }
                        }
                    }

                    if(add&&t>0)
                        count++;
                }
            }
        }

        return count;
    }
}
