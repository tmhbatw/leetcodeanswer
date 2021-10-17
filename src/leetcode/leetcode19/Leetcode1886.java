package leetcode.leetcode19;

import java.util.Arrays;

public class Leetcode1886 {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0;i<4;i++){
            if(isSame(mat,target))
                return true;
            mat=getMat(mat);
        }
        return false;
    }

    private boolean isSame(int[][] mat1,int[][] mat2){
        for(int i=0;i<mat1.length;i++){
            for(int j=0;j<mat1[0].length;j++){
                if(mat1[i][j]!=mat2[i][j])
                    return false;
            }
        }
        return true;
    }

    private int[][] getMat(int[][] mat){
        int n=mat.length;
        int[][] newMat=new int[n][n];
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){
                newMat[j][n-i-1]=mat[i][j];
                newMat[n-i-1][n-1-j]=mat[j][n-i-1];
                newMat[n-1-j][i]=mat[n-i-1][n-1-j];
                newMat[i][j]=mat[n-1-j][i];
            }
        }
        if(n%2==1)
            newMat[n/2][n/2]=mat[n/2][n/2];
        return newMat;
    }
}
