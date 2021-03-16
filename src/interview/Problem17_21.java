package interview;

import java.util.Stack;

public class Problem17_21 {
    /*Description
    * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
    * */

    public int trap(int[] height) {
        if(height.length<=1)
            return 0;
        Stack<Point> order=new Stack<>();
        Stack<Point> reverse=new Stack<>();
        for(int i=0;i<height.length;i++){
            if(order.isEmpty()||height[i]>=order.peek().val)
                order.push(new Point(i,height[i]));
        }
        int max=order.peek().val;
        for(int i=height.length-1;i>=0;i--){
            if(reverse.isEmpty()||reverse.peek().val<=height[i]) {
                reverse.push(new Point(i, height[i]));
                if(height[i]==max)
                    break;
            }
        }
        return getRes(order,height)+getRes(reverse,height);
    }

    private int getRes(Stack<Point> s,int [] height){
        Point pre=s.pop();
        int result=0;
        while(!s.isEmpty()){
            Point cur=s.pop();
            int val=cur.val;
            for(int i=Math.min(cur.index,pre.index);i<=Math.max(cur.index,pre.index);i++){
                result+=Math.max(val-height[i],0);
            }
        }
        return result;
    }

    class Point{
        int index,val;
        public Point(int index,int val){
            this.index=index;
            this.val=val;
        }
    }
}
