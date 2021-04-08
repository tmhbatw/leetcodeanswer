package leetcode.leetcode1;

import java.util.Stack;

public class Leetcode42 {
    /*Description
    * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    * */

    public int trap(int[] height) {
        if(height==null||height.length<=1)
            return 0;
        int max=0;
        Stack<int[]> preStack=new Stack<>();
        for(int i=0;i<height.length;i++){
            if(preStack.empty()||preStack.peek()[0]<=height[i])
                preStack.add(new int[]{height[i],i});
            max=Math.max(max,height[i]);
        }
        int result=0;
        result+=getRes(preStack,height,true);
        Stack<int[]> postStack=new Stack<>();
        for(int i=height.length-1;i>=0;i--){
            if(postStack.empty()||postStack.peek()[0]<=height[i])
                postStack.add(new int[]{height[i],i});
            if(height[i]==max)
                break;
        }
        result+=getRes(postStack,height,false);
        return result;
    }

    private int getRes(Stack<int[]> preStack,int[] height,boolean pre){
        int[] cur=preStack.pop();
        int result=0;
        while(!preStack.empty()){
            int[] curHeight=preStack.pop();
            if(pre) {
                for (int i = curHeight[1] + 1; i <= cur[1] - 1; i++) {
                    result += curHeight[0] - height[i];
                }
            }else{
                for (int i = cur[1] + 1; i <= curHeight[1] - 1; i++) {
                    result += curHeight[0] - height[i];
                }
            }
            cur=curHeight;
        }
        return result;
    }
}
