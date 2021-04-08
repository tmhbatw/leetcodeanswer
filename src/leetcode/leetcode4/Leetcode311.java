package leetcode.leetcode4;

public class Leetcode311 {
    /*Description
    * 给你两个 稀疏矩阵 A 和 B，请你返回 AB 的结果。你可以默认 A 的列数等于 B 的行数。
    * 请仔细阅读下面的示例。
    * */

    public int[][] multiply(int[][] A, int[][] B) {
        int rowA=A.length,colA=A[0].length;
        int rowB=B.length,colB=B[0].length;
        int[][] res=new int[rowA][colB];
        for(int i=0;i<rowA;i++){
            for(int j=0;j<colB;j++){
                for(int m=0;m<colA;m++)
                    res[i][j]+=A[i][m]*B[m][j];
            }
        }
        return res;
    }
}
