package leetcode.leetcode12;

import java.util.concurrent.Semaphore;

public class Leetcode1117 {

    class H2O {

        Semaphore a;
        Semaphore b;
        public H2O() {
            this.a=new Semaphore(2);
            this.b=new Semaphore(0);
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            this.b.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            this.a.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            this.a.acquire(2);
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            this.b.release(2);
        }
    }
}
