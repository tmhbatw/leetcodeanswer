package forOffer;

import java.util.Arrays;

public class forOffer29 {
    /*Description
    * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
    * */

    int[][] pos=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int index=0;
    int i=0,j=0;
    int startRow=1,startCol=0;
    int endRow,endCol;
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0)
            return new int[0];
        endRow=matrix.length;
        endCol=matrix[0].length;
        int[] res=new int[endRow--*endCol--];
        int cur=0;
        while(cur<res.length){
            res[cur++]=matrix[i][j];
            addPos();
        }
        return res;
    }


    private void addPos(){
        if(index==0&&j==endCol){
            endCol--;
            index++;
        }
        else if(index==1&&i==endRow){

            endRow--;
            index++;
        }
        else if(index==2&&j==startCol){
            startCol++;
            index++;
        }
        else if(index==3&&i==startRow){
            startRow++;
            index=0;
        }
        int[] nextPos=pos[index];
        i+=nextPos[0];j+=nextPos[1];
    }
}
