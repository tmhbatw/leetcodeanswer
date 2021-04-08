package leetcode.leetcode7;

public class Leetcode661 {
    /*Description
    * 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
    * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
    * */

    public int[][] imageSmoother(int[][] M) {
        int row=M.length,N=M[0].length;
        int[][] res=new int[row][N];
        int[][] pos=new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                int curTime=1;
                int curVal=M[i][j];
                for(int[] nextPos:pos){
                    int ii=i+nextPos[0],jj=j+nextPos[1];
                    if(ii>=0&&ii<row&&jj>=0&&jj<N){
                        curTime++;
                        curVal+=M[ii][jj];
                    }
                }
                res[i][j]=curVal/curTime;
            }
        }
        return res;
    }
}
