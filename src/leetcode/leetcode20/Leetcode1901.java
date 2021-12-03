package leetcode.leetcode20;

public class Leetcode1901 {

    public int[] findPeakGrid(int[][] mat) {
        int row=mat.length,col=mat[0].length;

        int u=0,d=row-1;
        while(u<=d){
            int mid=(u+d)/2;
            int index=0,max=0;
            for(int j=0;j<col;j++){
                if(mat[mid][j]>max){
                    index=j;
                    max=mat[mid][j];
                }
            }

            if(mid>=1&&mat[mid][index]<mat[mid-1][index]){
                d=mid-1;
                continue;
            }
            if(mid<row-1&&mat[mid][index]<mat[mid+1][index]){
                u=mid+1;
                continue;
            }

            return new int[]{mid,index};
        }
        return new int[]{0,0};
    }
}
