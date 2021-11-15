package leetcode.leetcode5;

import java.util.ArrayList;
import java.util.List;

public class Leetcode498 {

    int row,col;
    boolean inorder=false;
    int index=0;
    int[] res;
    public int[] findDiagonalOrder(int[][] mat) {
        row=mat.length;
        col=mat[0].length;
        res=new int[row*col];

        for(int j=0;j<col;j++){
            add(0,j,mat);
        }

        for(int i=1;i<row;i++){
            add(i,col-1,mat);
        }
        return res;
    }

    private void add(int i1,int j1,int[][] mat){
        List<Integer> list=new ArrayList<>();
        while(j1>=0&&i1<row){
            list.add(mat[i1++][j1--]);
        }
        if(inorder){
            for(int l=0;l<list.size();l++)
                res[index++]=list.get(l);
        }else{
            for(int l=list.size()-1;l>=0;l--)
                res[index++]=list.get(l);
        }
        inorder=!inorder;
    }
}
