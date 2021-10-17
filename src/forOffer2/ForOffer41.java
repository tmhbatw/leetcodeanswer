package forOffer2;

import java.util.ArrayDeque;
import java.util.Deque;

public class ForOffer41 {

    class MovingAverage {

        /** Initialize your data structure here. */
        Deque<Integer> dq=new ArrayDeque<>();
        int size=0;
        int sum=0;
        public MovingAverage(int size) {
            this.size=size;
        }

        public double next(int val) {
            sum+=val;
            dq.addLast(val);
            if(dq.size()>size)
                sum-=dq.pollFirst();
            return sum*1.0/dq.size();
        }
    }
}
