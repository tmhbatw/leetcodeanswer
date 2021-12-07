package leetcode.leetcode18;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1730 {

    public int getFood(char[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int row=grid.length;
        int col=grid[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='*')
                    q.add(new int[]{i,j});
            }
        }

        int distance=0;
        int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size=q.size();
            distance++;
            while(size-->0) {
                int[] cur = q.poll();
                for(int[] next:nextPos){
                    int ii=cur[0]+next[0];
                    int jj=cur[1]+next[1];
                    if(ii>=0&&ii<row&&jj>=0&&jj<col){
                        if(grid[ii][jj]=='#')
                            return distance;
                        if(grid[ii][jj]=='O'){
                            q.add(new int[]{ii,jj});
                            grid[ii][jj]='X';
                        }
                    }
                }
            }
        }
        return -1;
    }
}
