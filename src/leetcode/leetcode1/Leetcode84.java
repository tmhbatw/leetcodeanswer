package leetcode.leetcode1;

import java.util.Stack;

public class Leetcode84 {
    /*Description
    * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
    * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
    * */

    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0)
            return 0;
        Stack<int[]> stack=new Stack<>();
        stack.add(new int[]{-1,-1});
        int length=heights.length;
        int[] left=new int[length];
        for(int i=0;i<length;i++){
            while(stack.peek()[0]>=heights[i])
                stack.pop();
            left[i]=stack.peek()[1];
            stack.add(new int[]{heights[i],i});
        }
        stack=new Stack<>();
        int result=0;
        stack.add(new int[]{-1,length});
        for(int i=length-1;i>=0;i--){
            while(stack.peek()[0]>=heights[i])
                stack.pop();
            int right=stack.peek()[1];
            result=Math.max(result,(right-left[i]-1)*heights[i]);
            stack.add(new int[]{heights[i],i});
        }
        return result;
    }
}
