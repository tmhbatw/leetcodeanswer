package leetcode.leetcode8;

import java.util.Stack;

public class Leetcode716 {
    /*Description
    * 设计一个最大栈数据结构，既支持栈操作，又支持查找栈中最大元素。
    * 实现MaxStack类：
    * MaxStack()初始化栈对象
    * void push(int x)将元素 x 压入栈中。
    * int pop()移除栈顶元素并返回这个元素。
    * int top()返回栈顶元素，无需移除。
    * int peekMax()检索并返回栈中最大元素，无需移除。
    * int popMax()检索并返回栈中最大元素，并将其移除。如果有多个最大元素，只要移除 最靠近栈顶 的那个。
    * */

    class MaxStack {
        Stack<Integer> stack;
        Stack<Integer> maxStack;

        /** initialize your data structure here. */
        public MaxStack() {
            stack=new Stack<>();
            maxStack=new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if(maxStack.isEmpty()||maxStack.peek()<=x)
                maxStack.push(x);
        }

        public int pop() {
            int val=stack.pop();
            if(val==maxStack.peek())
                maxStack.pop();
            return val;
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax() {
            int max=maxStack.pop();
            Stack<Integer> q=new Stack<>();
            while(stack.peek()!=max){
                q.add(stack.pop());
            }
            stack.pop();
            while(!q.isEmpty()){
                int cur=q.pop();
                stack.push(cur);
                if(maxStack.isEmpty()||maxStack.peek()<=cur)
                    maxStack.push(cur);
            }
            return max;
        }
    }
}
