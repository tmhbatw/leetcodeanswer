package leetcode.leetcode19;

import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class Leetcode1845 {

    class SeatManager {
        int result;
        PriorityQueue<Integer> q;
        public SeatManager(int n) {
            this.result=1;
            this.q=new PriorityQueue<>();
        }

        public int reserve() {
            if(q.isEmpty())
                return result++;
            return q.poll();
        }

        public void unreserve(int seatNumber) {
            q.add(seatNumber);
        }
    }
}
