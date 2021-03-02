package forOffer;

import java.util.Stack;

public class forOffer30 {
    /*Description
    * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
    * */

    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> min;
        /** initialize your data structure here. */
        public MinStack() {
            stack=new Stack<>();
            min=new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if(min.isEmpty()||min.peek()>=x){
                min.push(x);
            }
        }

        public void pop() {
            int val=stack.pop();
            if(val==min.peek())
                min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min.peek();
        }
    }
}
