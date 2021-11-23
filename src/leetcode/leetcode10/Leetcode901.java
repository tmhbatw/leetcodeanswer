package leetcode.leetcode10;

import java.util.Stack;

public class Leetcode901 {

    class StockSpanner {

        Stack<int[]> s;
        int index=-1;
        public StockSpanner() {
            s=new Stack<>();
            s.add(new int[]{Integer.MAX_VALUE,index++});
        }

        public int next(int price) {
            while(s.peek()[0]<=price){
                s.pop();
            }
            int res=index-s.peek()[1];
            s.add(new int[]{price,index});
            index++;
            return res;
        }
    }
}
