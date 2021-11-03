package leetcode.leetcode12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Leetcode1188 {

    class BoundedBlockingQueue {
        Semaphore a;
        Queue<Integer> q=new LinkedList<>();
        Semaphore b;

        public BoundedBlockingQueue(int capacity) {
            a=new Semaphore(capacity);
            b=new Semaphore(0);
        }

        public void enqueue(int element) throws InterruptedException {
            a.acquire();
            q.add(element);
            b.release();
        }

        public int dequeue() throws InterruptedException {
            b.acquire();
            int cur=q.poll();
            a.release();
            return cur;
        }

        public int size() {
            return q.size();
        }
    }
}
