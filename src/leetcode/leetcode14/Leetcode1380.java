package leetcode.leetcode14;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1380 {

    public List<Integer> luckyNumbers (int[][] matrix) {
        int row=matrix.length,col=matrix[0].length;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                boolean flag=true;
                for(int j1=0;j1<col&&flag;j1++){
                    if(matrix[i][j1]<matrix[i][j]){
                        flag=false;
                    }
                }
                for(int i1=0;i1<row&&flag;i1++){
                    if(matrix[i1][j]>matrix[i][j]){
                        flag=false;
                    }
                }
                if(flag)
                    list.add(matrix[i][j]);
            }
        }
        return list;
    }
}
