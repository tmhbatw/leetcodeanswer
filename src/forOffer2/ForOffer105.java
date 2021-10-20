package forOffer2;

import java.util.LinkedList;
import java.util.Queue;

public class ForOffer105 {

    public int maxAreaOfIsland(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        boolean[][] reached=new boolean[row][col];
        int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int result=0;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1&&!reached[i][j]){
                    int count=1;
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    reached[i][j]=true;

                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        for(int[] next:nextPos){
                            int ii=next[0]+cur[0];
                            int jj=next[1]+cur[1];
                            if(ii>=0&&ii<row&&jj>=0&&jj<col&&grid[ii][jj]==1&&!reached[ii][jj]){
                                reached[ii][jj]=true;
                                q.add(new int[]{ii,jj});
                                count++;
                            }
                        }
                    }

                    result=Math.max(result,count);
                }
            }
        }
        return result;
    }
}
