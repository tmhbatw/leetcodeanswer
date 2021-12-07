package leetcode.leetcode11;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1020 {

    int[][] newtPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int numEnclaves(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        int result=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    boolean flag=true;
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    grid[i][j]=0;
                    int count=1;
                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        for(int[] next:newtPos){
                            int ii=cur[0]+next[0];
                            int jj=cur[1]+next[1];
                            if(ii<0||ii>=row||jj<0||jj>=col)
                                flag=false;
                            else{
                                if(grid[ii][jj]==1){
                                    grid[ii][jj]=0;
                                    count++;
                                    q.add(new int[]{ii,jj});
                                }
                            }
                        }
                    }
                    if(flag)
                        result+=count;
                }
            }
        }
        return result;
    }
}
