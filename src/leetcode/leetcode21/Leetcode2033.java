package leetcode.leetcode21;

import java.util.Arrays;

public class Leetcode2033 {

    public int minOperations(int[][] grid, int x) {

        int row=grid.length,col=grid[0].length;
        int[] time=new int[row*col];
        int index=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                time[index++]=grid[i][j];
            }
        }

        Arrays.sort(time);
        int mid=time[time.length/2];

        int result=0;
        for(int num:time){
            int max=Math.max(num,mid);
            int min=Math.min(num,mid);
            if((max-min)%x!=0)
                return -1;
            result+=(max-min)/x;
        }

        return result;
    }
}
