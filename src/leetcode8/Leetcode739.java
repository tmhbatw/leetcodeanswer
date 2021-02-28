package leetcode8;

import java.util.Stack;

public class Leetcode739{
    /*Description
    * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用0 来代替。
    * 例如，给定一个列表temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
    * 提示：气温 列表长度的范围是[1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
    * */

    /*Solution
    * 维持一个单调递减栈
    * */
    public int[] dailyTemperatures(int[] T) {
        int length=T.length;
        int[] res=new int[T.length];
        Stack<Point> s=new Stack<>();
        for(int i=0;i<T.length;i++){
            while(!s.isEmpty()&&s.peek().val<T[i]){
                Point cur=s.pop();
                res[cur.index]=i-cur.index;
            }
            s.push(new Point(T[i],i));
        }
        return res;
    }

    class Point{
        int val;
        int index;
        public Point(int val,int index){
            this.val=val;
            this.index=index;
        }
    }
}
