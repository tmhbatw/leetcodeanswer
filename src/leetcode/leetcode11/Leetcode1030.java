package leetcode.leetcode11;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1030 {

    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        boolean[][] reached=new boolean[rows][cols];
        reached[rCenter][cCenter]=true;
        int[][] res=new int[rows*cols][2];
        int index=0;
        res[index++]=new int[]{rCenter,cCenter};

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{rCenter,cCenter});

        while(!q.isEmpty()){
            int[] cur=q.poll();
            for(int[] next:nextPos){
                int ii=cur[0]+next[0];
                int jj=cur[1]+next[1];
                if(ii>=0&&ii<rows&&jj>=0&&jj<cols&&!reached[ii][jj]){
                    reached[ii][jj]=true;
                    q.add(new int[]{ii,jj});
                    res[index++]=new int[]{ii,jj};
                }
            }
        }

        return  res;
    }
}
