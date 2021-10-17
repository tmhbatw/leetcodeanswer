package forOffer2;

import java.util.ArrayDeque;
import java.util.Deque;

public class ForOffer42 {

    class RecentCounter {

        Deque<Integer> dq=new ArrayDeque<>();
        public RecentCounter() {

        }

        public int ping(int t) {
            dq.add(t);
            while(!dq.isEmpty()&&dq.peekFirst()<t-3000)
                dq.pollFirst();
            return dq.size();
        }
    }

}
