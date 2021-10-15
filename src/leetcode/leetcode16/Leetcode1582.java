package leetcode.leetcode16;

public class Leetcode1582 {
    public int numSpecial(int[][] mat) {
        int count=0;
        int row=mat.length,col=mat[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==1){
                    boolean flag=true;
                    for(int ii=0;ii<row&&flag;ii++){
                        if(i==ii)
                            continue;
                        if(mat[ii][j]!=0)
                            flag=false;
                    }
                    for(int jj=0;jj<col&&flag;jj++){
                        if(j==jj)
                            continue;
                        if(mat[i][jj]!=0)
                            flag=false;
                    }
                    if(flag)
                        count++;
                }
            }
        }
        return count;
    }
}
