package leetcode.leetcode9;

public class Leetcode840 {

    public int numMagicSquaresInside(int[][] grid) {
        int result=0;
        for(int i=0;i<grid.length-2;i++){
            for(int j=0;j<grid[0].length-2;j++){
                result+=getRes(grid,i,j);
            }
        }
        return result;
    }

    private int getRes(int[][] grid,int i,int j){
        boolean[] reached=new boolean[10];
        for(int ii=i;ii<i+3;ii++){
            for(int jj=j;jj<j+3;jj++){
                if(grid[ii][jj]>9||grid[ii][jj]<1||reached[grid[ii][jj]])
                    return 0;
                reached[grid[ii][jj]]=true;
            }
        }
        int t=grid[i][j]+grid[i][j+1]+grid[i][j+2];
        for(int ii=i;ii<=i+2;ii++){
            int cur=grid[ii][j]+grid[ii][j+1]+grid[ii][j+2];
            if(cur!=t)
                return 0;
        }
        for(int jj=j;jj<=j+2;jj++){
            int cur=grid[i][jj]+grid[i+1][jj]+grid[i+2][jj];
            if(cur!=t)
                return 0;
        }
        if(t!= grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2])
            return 0;
        if(t!=grid[i+2][j]+grid[i+1][j+1]+grid[i][j+2])
            return 0;
        return 1;
    }

}
