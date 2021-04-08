package leetcode.leetcode1;

import java.util.Stack;

public class Leetcode85 {
    /*Description
    *给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
    * */

    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0)
            return 0;
        int row=matrix.length,col=matrix[0].length;
        int[][] time=new int[row+1][col];
        int result=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='1')
                    time[i+1][j]=time[i][j]+1;
            }
            int[] left=new int[col];
            Stack<int[]> stack=new Stack<>();
            stack.add(new int[]{-1,-1});
            for(int j=0;j<col;j++){
                while(stack.peek()[0]>=time[i+1][j])
                    stack.pop();
                left[j]=stack.peek()[1];
                stack.add(new int[]{time[i+1][j],j});
            }
            stack=new Stack<>();
            stack.add(new int[]{-1,col});
            for(int j=col-1;j>=0;j--){
                while(stack.peek()[0]>=time[i+1][j])
                    stack.pop();
                int right=stack.peek()[1];
                result=Math.max(result,(right-left[j]-1)*time[i+1][j]);
                stack.add(new int[]{time[i+1][j],j});
            }
        }
        return result;
    }
}
