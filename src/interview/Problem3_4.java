package interview;

import java.util.Stack;

public class Problem3_4 {
    /*Description
    * 实现一个MyQueue类，该类用两个栈来实现一个队列。
    * */

    class MyQueue {

        Stack<Integer> add;
        Stack<Integer> del;
        boolean isAddStatus=true;
        /** Initialize your data structure here. */
        public MyQueue() {
            add=new Stack<>();
            del=new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if(!isAddStatus){
                isAddStatus= true;
                while(!del.isEmpty())
                    add.add(del.pop());
            }
            add.add(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(isAddStatus){
                isAddStatus=false;
                while(!add.isEmpty())
                    del.add(add.pop());
            }
            return del.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(isAddStatus){
                isAddStatus=false;
                while(!add.isEmpty())
                    del.add(add.pop());
            }
            return del.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return add.isEmpty()&&del.isEmpty();
        }
    }

}
