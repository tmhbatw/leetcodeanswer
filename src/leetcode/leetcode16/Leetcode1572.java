package leetcode.leetcode16;

public class Leetcode1572 {

    public int diagonalSum(int[][] mat) {
        int res=0;
        for(int i=0;i<mat.length;i++)
            res+=mat[i][i]+mat[i][mat.length-1-i];
        if(mat.length%2==1)
            res-=mat[mat.length/2][mat.length/2];
        return res;
    }
}
