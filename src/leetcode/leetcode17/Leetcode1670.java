package leetcode.leetcode17;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode1670 {

    class FrontMiddleBackQueue {

        //保证前半个永远大于等于后半个
        Deque<Integer> q1;
        Deque<Integer> q2;
        public FrontMiddleBackQueue() {
            this.q1=new ArrayDeque<>();
            this.q2=new ArrayDeque<>();
        }

        public void pushFront(int val) {
            q1.addFirst(val);
            if(q1.size()-q2.size()==2){
                q2.addFirst(q1.pollLast());
            }
        }

        public void pushMiddle(int val) {
            if (q1.size() != q2.size()) {
                q2.addFirst(q1.pollLast());
            }
            q1.addLast(val);

        }

        public void pushBack(int val) {
            q2.addLast(val);
            if(q2.size()>q1.size()){
                q1.addLast(q2.pollFirst());
            }

        }

        public int popFront() {
            if(q1.size()==0)
                return -1;
            int result=q1.pollFirst();
            if(q1.size()<q2.size())
                q1.addLast(q2.pollFirst());
            return result;
        }

        public int popMiddle() {
            if(q1.isEmpty())
                return -1;
            if(q1.size()==q2.size()){
                int result=q1.pollLast();
                q1.addLast(q2.pollFirst());
                return result;
            }
            return q1.pollLast();
        }

        public int popBack() {
            if(q2.isEmpty()){
                if(q1.isEmpty())
                    return -1;
                return q1.pollLast();
            }
            int result=q2.pollLast();
            if(q1.size()-q2.size()==2)
                q2.addFirst(q1.pollLast());
            return result;
        }
    }
}
