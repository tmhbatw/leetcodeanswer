package leetcode.leetcode6;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode542 {

    public int[][] updateMatrix(int[][] mat) {
        int row=mat.length,col=mat[0].length;

        int[][] res=new int[row][col];
        boolean[][] reached=new boolean[row][col];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==0){
                    reached[i][j]=true;
                    q.add(new int[]{i,j});
                }
            }
        }

        int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int distance=0;
        while(!q.isEmpty()){
            distance++;
            int size=q.size();
            while(size-->0){
                int[] cur=q.poll();
                for(int[] next:nextPos){
                    int ii=cur[0]+next[0];
                    int jj=cur[1]+next[1];
                    if(ii>=0&&ii<row&&jj>=0&&jj<col&&!reached[ii][jj]){
                        res[ii][jj]=distance;
                        reached[ii][jj]=true;
                        q.add(new int[]{ii,jj});
                    }
                }
            }
        }
        return res;
    }
}
