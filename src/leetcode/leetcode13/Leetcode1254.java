package leetcode.leetcode13;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1254 {

    public int closedIsland(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        int result=0;
        int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1)
                    continue;
                Queue<int[]> q=new LinkedList<>();
                q.add(new int[]{i,j});
                boolean isMatch=true;
                while(!q.isEmpty()){
                    int[] cur=q.poll();
                    for(int[] next:nextPos){
                        int ii=next[0]+cur[0];
                        int jj=next[1]+cur[1];
                        if(ii<0||ii>=row||jj<0||jj>=col){
                            isMatch=false;
                            continue;
                        }
                        if(grid[ii][jj]==0){
                            grid[ii][jj]=1;
                            q.add(new int[]{ii,jj});
                        }
                    }
                }
                if(isMatch)
                    result++;
            }
        }
        return result;
    }

}
