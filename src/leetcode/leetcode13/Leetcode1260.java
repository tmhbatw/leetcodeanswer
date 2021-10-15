package leetcode.leetcode13;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1260 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        while(k-->0)
            grid=getChange(grid);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            List<Integer> res=new ArrayList<>();
            for(int j=0;j<grid[0].length;j++)
                res.add(grid[i][j]);
            list.add(res);
        }
        return list;
    }

    private int[][] getChange(int[][] grid){
        int row=grid.length,col=grid[0].length;
        int[][] res=new int[row][col];
        for(int i=0;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                res[i][j]=grid[i][j-1];
            }
        }
        for(int i=1;i<row;i++)
            res[i][0]=grid[i-1][col-1];
        res[0][0]=grid[row-1][col-1];
        return res;
    }
}
