package leetcode2;

import java.util.Stack;

public class Leetcode155 {
    /*Description
    * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
    * push(x) —— 将元素 x 推入栈中。
    * pop()—— 删除栈顶的元素。
    * top()—— 获取栈顶元素。
    * getMin() —— 检索栈中的最小元素。
    * */

    class MinStack {
        Stack<Integer> stack;//用来存储全部的数
        Stack<Integer> min;//用来存储最小数堆

        /** initialize your data structure here. */
        public MinStack() {
            this.stack=new Stack<>();
            this.min=new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if(min.empty()||min.peek()>=x)
                min.push(x);
        }

        public void pop() {
            if(min.peek().equals(stack.pop()))
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
