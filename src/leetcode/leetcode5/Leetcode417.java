package leetcode.leetcode5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode417 {

    int row;
    int col;
    int[][] nextPos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.row=heights.length;
        this.col=heights[0].length;

        int[][] res=new int[row][col];
        Queue<int[]> q=new LinkedList<>();
        boolean[][] reached=new boolean[row][col];
        for(int i=1;i<row;i++){
            reached[i][0]=true;
            q.add(new int[]{i,0});
            res[i][0]++;
        }
        for(int j=0;j<col;j++){
            reached[0][j]=true;
            q.add(new int[]{0,j});
            res[0][j]++;
        }
        getRes(res,q,heights,reached);

        reached=new boolean[row][col];
        for(int i=0;i<row;i++){
            reached[i][col-1]=true;
            q.add(new int[]{i,col-1});
            res[i][col-1]++;
        }
        for(int j=0;j<col-1;j++){
            reached[row-1][j]=true;
            q.add(new int[]{row-1,j});
            res[row-1][j]++;
        }
        getRes(res,q,heights,reached);

        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(res[i][j]==2) {
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }
        return result;
    }

    private void getRes(int[][] res, Queue<int[]> queue,
                        int[][] heights,boolean[][] reached){
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            for(int[] next:nextPos){
                int ii=cur[0]+next[0];
                int jj=cur[1]+next[1];
                if(ii>=0&&ii<row&&jj>=0&&jj<col&&!reached[ii][jj]&&
                        heights[ii][jj]>=heights[cur[0]][cur[1]]){
                    queue.add(new int[]{ii,jj});
                    res[ii][jj]++;
                    reached[ii][jj]=true;
                }
            }
        }
    }
}
