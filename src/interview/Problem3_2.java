package interview;

import java.util.Stack;

public class Problem3_2 {
    /*Description
    * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。
    * 执行push、pop和min操作的时间复杂度必须为O(1)。
    * 来源：力扣（LeetCode）
    * */

    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> min;
        /** initialize your data structure here. */
        public MinStack() {
            stack=new Stack<>();
            min=new Stack<>();
            min.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            stack.push(x);
            if(x<=min.peek())
                min.push(x);
        }

        public void pop() {
            int val=stack.pop();
            if(val==min.peek())
                min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
