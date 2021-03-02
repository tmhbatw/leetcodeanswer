package leetcode4;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode317 {
    /*Description
    * 你是个房地产开发商，想要选择一片空地 建一栋大楼。你想把这栋大楼够造在一个距离周边设施都比较方便的地方，
    * 通过调研，你希望从它出发能在最短的距离和内抵达周边全部的建筑物。请你计算出这个最佳的选址到周边全部建筑物的最短距离和。
    * */

    int[][] time;
    int[][] grid;
    int[][] number;
    int row,col;
    public int shortestDistance(int[][] grid) {
        row=grid.length;
        col=grid[0].length;
        time=new int[row][col];
        number=new int[row][col];
        int num=0;
        this.grid=grid;
        int[][] pos=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    num++;
                    Queue<int[]> list=new LinkedList<>();
                    boolean[][] reached=new boolean[row][col];
                    list.add(new int[]{i,j});
                    int curTime=1;
                    while(!list.isEmpty()){
                        int size=list.size();
                        for(int l=0;l<size;l++){
                            int[] cur=list.poll();
                            for(int[] nextPos:pos){
                                int ii=cur[0]+nextPos[0],jj=cur[1]+nextPos[1];
                                if(ii>=0&&ii<row&&jj>=0&&jj<col&&!reached[ii][jj]&&grid[ii][jj]==0){
                                    number[ii][jj]++;
                                    time[ii][jj]+=curTime;
                                    reached[ii][jj]=true;
                                    list.add(new int[]{ii,jj});
                                }
                            }
                        }
                        curTime++;
                    }
                }
            }
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(number[i][j]==num){
                    res=Math.min(res,time[i][j]);
                }
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }


}
