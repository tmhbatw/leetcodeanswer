package interview;

import java.util.PriorityQueue;

public class Problem3_5 {
    /*Description
    * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，
    * 但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
    * */

    class SortedStack {

        PriorityQueue<Integer> q;

        public SortedStack() {
            q=new PriorityQueue<>();
        }

        public void push(int val) {
            q.add(val);
        }

        public void pop() {
            q.poll();
        }

        public int peek() {
            return (isEmpty())?-1:q.peek();
        }

        public boolean isEmpty() {
            return q.isEmpty();
        }
    }
}
