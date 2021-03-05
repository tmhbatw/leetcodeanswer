package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem8_2 {
    /*Description
    * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。
    * 设计一种算法，寻找机器人从左上角移动到右下角的路径。
    * */


    List<List<Integer>> result=null;
    List<List<Integer>> cur;
    int[][] board;
    boolean[][] reached;
    int row,col;
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0)
            return Collections.emptyList();
        if(obstacleGrid[0][0]==1)
            return Collections.emptyList();
        cur=new ArrayList<>();
        this.board=obstacleGrid;
        this.row=obstacleGrid.length;
        this.col=obstacleGrid[0].length;
        this.reached=new boolean[row][col];
        List<Integer> list=new ArrayList<>();
        list.add(0);
        list.add(0);
        cur.add(list);
        reached[0][0]=true;
        dfs(0,0);
        return result==null? Collections.emptyList():result;
    }

    private void dfs(int i,int j){
        if(result!=null)
            return;
        if(i==row-1&&j==col-1){
            result=new ArrayList<>(cur);
            return;
        }
        if(i<row-1&&board[i+1][j]!=1&&!reached[i+1][j]){
            List<Integer> list=new ArrayList<>();
            list.add(i+1);
            list.add(j);
            cur.add(list);
            reached[i+1][j]=true;
            dfs(i+1,j);
            cur.remove(cur.size()-1);
        }
        if(j<col-1&&board[i][j+1]!=1&&!reached[i][j+1]){
            List<Integer> list=new ArrayList<>();
            list.add(i);
            list.add(j+1);
            cur.add(list);
            reached[i][j+1]=true;
            dfs(i,j+1);
            cur.remove(cur.size()-1);
        }
    }
}
