package leetcode.leetcode14;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1391 {

    int m;
    int n;

    public boolean hasValidPath(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        int[] type=new int[m*n];
        for(int i=0;i<type.length;i++)
            type[i]=i;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                List<int[]> merge=new ArrayList<>();
                switch (grid[i][j]) {
                    case 1:
                        if(j>=1&&(grid[i][j-1]==1||grid[i][j-1]==4||grid[i][j-1]==6))
                            merge.add(new int[]{i,j-1});
                        if(j<n-1&&(grid[i][j+1]==1||grid[i][j+1]==3||grid[i][j+1]==5))
                            merge.add(new int[]{i,j+1});
                        break;
                    case 2:
                        if(i>=1&&(grid[i-1][j]==2||grid[i-1][j]==3||grid[i-1][j]==4))
                            merge.add(new int[]{i-1,j});
                        if(i<m-1&&(grid[i+1][j]==2||grid[i+1][j]==5||grid[i+1][j]==6))
                            merge.add(new int[]{i+1,j});
                        break;
                    case 3:
                        if(j>=1&&(grid[i][j-1]==1||grid[i][j-1]==4||grid[i][j-1]==6))
                            merge.add(new int[]{i,j-1});
                        if(i<m-1&&(grid[i+1][j]==2||grid[i+1][j]==5||grid[i+1][j]==6))
                            merge.add(new int[]{i+1,j});
                        break;
                    case 4:
                        if(j<n-1&&(grid[i][j+1]==1||grid[i][j+1]==3||grid[i][j+1]==5))
                            merge.add(new int[]{i,j+1});
                        if(i<m-1&&(grid[i+1][j]==2||grid[i+1][j]==5||grid[i+1][j]==6))
                            merge.add(new int[]{i+1,j});
                        break;
                    case 5:
                        if(i>=1&&(grid[i-1][j]==2||grid[i-1][j]==3||grid[i-1][j]==4))
                            merge.add(new int[]{i-1,j});
                        if(j>=1&&(grid[i][j-1]==1||grid[i][j-1]==4||grid[i][j-1]==6))
                            merge.add(new int[]{i,j-1});
                        break;
                    case 6:
                        if(i>=1&&(grid[i-1][j]==2||grid[i-1][j]==3||grid[i-1][j]==4))
                            merge.add(new int[]{i-1,j});
                        if(j<n-1&&(grid[i][j+1]==1||grid[i][j+1]==3||grid[i][j+1]==5))
                            merge.add(new int[]{i,j+1});
                }

                merge.add(new int[]{i,j});
                for(int k=1;k<merge.size();k++){
                    merge(merge.get(0),merge.get(1),type);
                }
            }
        }

        int t1 = getType(getType(0,0),type);
        int t2=getType(getType(m-1,n-1),type);

        return t1==t2;
    }

    private void merge(int[] num1,int[] num2,int[] type){
        int type1=getType(num1[0],num1[1]);
        int type2=getType(num2[0],num2[1]);

        int t1=getType(type1,type);
        int t2=getType(type2,type);

        if(t1!=t2){
            type[t2]=t1;
        }
    }

    private int getType(int cur,int[] type){
        if(type[cur]==cur)
            return cur;
        return getType(type[cur],type);
    }

    private int getType(int x,int y){
        return x*n+y;
    }

    private int[] getType(int cur){
        return new int[]{cur/n,cur%n};
    }

}
