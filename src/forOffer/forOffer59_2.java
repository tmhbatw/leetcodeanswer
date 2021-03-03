package forOffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class forOffer59_2 {
    /*Description
    *请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
    * */

    /*Solution
    * 维护一个单调递减队列
    * */
    class MaxQueue {
        Queue<Integer> q;
        Deque<Integer> max;

        public MaxQueue() {
            q=new LinkedList<>();
            max=new ArrayDeque<>();
        }

        public int max_value() {
            if(q.isEmpty())
                return -1;
            return max.peekFirst();
        }

        public void push_back(int value) {
            q.add(value);
            while(!max.isEmpty()&&value>max.peekLast())
                max.pollLast();
            max.add(value);
        }

        public int pop_front() {
            if(q.isEmpty())
                return -1;
            int val=q.poll();
            if(max.peekFirst()==val)
                max.pollFirst();
            return val;
        }
    }
}
