package leetcode.leetcode19;

public class Leetcode1895 {

    int[][] r;
    int[][] c;
    int[][] grid;
    public int largestMagicSquare(int[][] grid) {
        int row = grid.length,col=grid[0].length;
        this.r=new int[row+1][col+1];
        this.c=new int[row+1][col+1];
        this.grid= grid;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                r[i+1][j+1] = r[i][j+1]+grid[i][j];
                c[i+1][j+1] = c[i+1][j]+grid[i][j];
            }
        }

        int result =1;
        for (int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                for (int k=result;k<Math.min(row-i,col-j);k++){
                    if(match(i,j,k)){
                        result=Math.max(result,k+1);
                    }
                }
            }
        }

        return result;
    }

    private boolean match(int i,int j,int k) {
        int target = r[i+k+1][j+1]-r[i][j+1];

        for(int jj=j;jj<=j+k;jj++){
            if(target!=  r[i+k+1][jj+1]-r[i][jj+1])
                return false;
        }

        for(int ii=i;ii<=i+k;ii++){
            if(target != c[ii+1][j+k+1]-c[ii+1][j])
                return false;
        }

        int one=0;
        for(int kk=0;kk<=k;kk++){
            one += grid[i+kk][j+kk];
        }
        if(one!=target)
            return false;
        int two =0;
        for(int kk=0;kk<=k;kk++){
            two+= grid[i+k-kk][j+kk];
        }
        return two==target;
    }

    public static void main(String[] args){
        int[][] t=new int[][]{{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};
        System.out.println(new Leetcode1895().largestMagicSquare(t));
    }
}
