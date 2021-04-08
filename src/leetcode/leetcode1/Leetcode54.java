package leetcode.leetcode1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode54 {
    /*Description
    * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
    * */
    /*PS
    * 使用状态模式可能使得代码更加简洁
    * */
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null||matrix.length==0)
            return Collections.emptyList();
        int[][] pos=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int rowStart=0,rowEnd=matrix.length-1,colStart=0,colEnd=matrix[0].length-1;
        int index=(rowEnd+1)*(colEnd+1)-1;
        int i=0,j=0;
        int posIndex=0;
        int status=0;
        List<Integer> result=new ArrayList<>();
        while(index-->0){
            result.add(matrix[i][j]);
            if(i==rowStart&&j==colEnd&&status==0){
                posIndex=addPosIndex(posIndex);
                rowStart++;
                status=1;
            }else if(i==rowEnd&&j==colEnd&&status==1){
                posIndex=addPosIndex(posIndex);
                colEnd--;
                status=2;
            }else if(i==rowEnd&&j==colStart&&status==2){
                posIndex=addPosIndex(posIndex);
                rowEnd--;
                status=3;
            }else if(i==rowStart&&j==colStart&&status==3){
                posIndex=addPosIndex(posIndex);
                colStart++;
                status=0;
            }
            int[] nextPos=pos[posIndex];
            i+=nextPos[0];
            j+=nextPos[1];
        }
        result.add(matrix[i][j]);
        return result;
    }
    private int addPosIndex(int posIndex){
        return posIndex==3?0:posIndex+1;
    }

    public static void main(String[] args){

    }
}
