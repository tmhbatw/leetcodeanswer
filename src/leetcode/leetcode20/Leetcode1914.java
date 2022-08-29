package leetcode.leetcode20;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1914 {

    public int[][] rotateGrid(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        for(int i=0;i<Math.min(m,n)/2;i++){
            int i1=i,j1=i;
            int i2=grid.length-1-i,j2=grid[0].length-1-i;

            List<Integer> list=new ArrayList<>();
            for(int jj=j1;jj<j2;jj++)
                list.add(grid[i1][jj]);
            for(int ii=i1;ii<i2;ii++)
                list.add(grid[ii][j2]);
            for(int jj=j2;jj>=j1+1;jj--)
                list.add(grid[i2][jj]);
            for(int ii=i2;ii>=i1+1;ii--)
                list.add(grid[ii][j1]);
            int index=k%list.size();
            int size=list.size();
            for(int jj=j1;jj<j2;jj++) {
                grid[i1][jj] =list.get(index);
                index=getRes(index, size);
            }
            for(int ii=i1;ii<i2;ii++) {
                grid[ii][j2]=list.get(index);
                index=getRes(index, size);
            }
            for(int jj=j2;jj>=j1+1;jj--) {
                grid[i2][jj]=list.get(index);
                index=getRes(index, size);
            }
            for(int ii=i2;ii>=i1+1;ii--) {
                grid[ii][j1]=list.get(index);
                index=getRes(index, size);
            }
        }

        return grid;
    }

    private int getRes(int index,int size){
        return index<size-1?index+1:0;
    }


}
