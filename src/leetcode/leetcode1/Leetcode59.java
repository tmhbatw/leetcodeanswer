package leetcode.leetcode1;

public class Leetcode59 {
    /*Description
    * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     * */

    public int[][] generateMatrix(int n) {
        int index=1;
        int[][] result=new int[n][n];
        int i=0,j=0;
        int[][] pos=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int posIndex=0;
        int status=0;
        int rowStart=0,rowEnd=n-1,colStart=0,colEnd=n-1;
        while(index<=n*n){
            result[i][j]=index;
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
            index++;
        }
        return result;
    }

    private int addPosIndex(int posIndex){
        return posIndex==3?0:posIndex+1;
    }
}
