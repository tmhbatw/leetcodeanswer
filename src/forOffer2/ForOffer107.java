package forOffer2;

import java.util.LinkedList;
import java.util.Queue;

public class ForOffer107 {
    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] mat) {
        int row=mat.length,col=mat[0].length;
        int[][] res=new int[row][col];
        Queue<int[]> q=new LinkedList<>();
        boolean[][] reached=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==0)
                    q.add(new int[]{i,j});
            }
        }
        int distance=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++) {
                int[] cur = q.poll();
                for (int[] next : nextPos) {
                    int ii = cur[0] + next[0];
                    int jj = cur[1] + next[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col && mat[ii][jj] == 1 && !reached[ii][jj]) {
                        reached[ii][jj]=true;
                        res[ii][jj]=distance;
                        q.add(new int[]{ii,jj});
                    }
                }
            }
            distance++;
        }
        return res;
    }
}
