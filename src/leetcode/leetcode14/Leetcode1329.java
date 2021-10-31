package leetcode.leetcode14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode1329 {

    public int[][] diagonalSort(int[][] mat) {
        int row=mat.length,col=mat[0].length;

        int[][] result=new int[row][col];
        for(int j=col-1;j>=0;j--){
            int jj=j;
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<row&&jj<col;i++,jj++){
                list.add(mat[i][jj]);
            }
            Collections.sort(list);
            jj=j;
            for(int i=0;i<row&&jj<col;i++,jj++){
                result[i][jj]=list.get(i);
            }
        }

        for(int i=1;i<row;i++){
            int ii=i;
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<col&&ii<row;ii++,j++){
                list.add(mat[ii][j]);
            }
            Collections.sort(list);
            ii=i;
            for(int j=0;j<col&&ii<row;ii++,j++){
                result[ii][j]=list.get(j);
            }
        }
        return result;
    }
}
