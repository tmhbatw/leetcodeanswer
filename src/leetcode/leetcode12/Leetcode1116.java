package leetcode.leetcode12;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Leetcode1116 {

    class ZeroEvenOdd {
        private int n;
        private Semaphore a;
        private Semaphore b;
        private Semaphore c;

        public ZeroEvenOdd(int n) {
            this.n = n;
            this.a=new Semaphore(1);
            this.b=new Semaphore(1);
            this.c=new Semaphore(0);
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for(int i=0;i<n;i++) {
                this.a.acquire();
                printNumber.accept(0);
                this.b.release();
                this.c.release();
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for(int i=1;i<=n;i+=2){
                this.b.acquire();
                this.b.acquire();
                printNumber.accept(i);
                this.a.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for(int i=2;i<=n;i+=2){
                this.c.acquire();
                this.c.acquire();
                printNumber.accept(i);
                this.a.release();
            }
        }
    }
}
