package leetcode.leetcode19;

import java.util.Arrays;

public class Leetcode1820 {


    int[] girl;
    boolean[] reached;
    int m;
    int n;
    public int maximumInvitations(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        this.girl=new int[n];

        Arrays.fill(girl,-1);
        int result=0;

        for(int i=0;i<m;i++){
            reached=new boolean[n];
            if(match(i,grid))
                result++;
        }
        return result;
    }

    private boolean match(int i,int[][] grid){
        for(int jj=0;jj<n;jj++){
            if(grid[i][jj]==1&&!reached[jj]){
                reached[jj]=true;
                if(girl[jj]==-1||match(girl[jj],grid)){
                    girl[jj]=i;
                    return true;
                }
            }
        }
        return false;
    }


}
