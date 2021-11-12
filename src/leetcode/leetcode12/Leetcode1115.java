package leetcode.leetcode12;

import java.util.concurrent.Semaphore;

public class Leetcode1115 {

    class FooBar {
        private int n;
        Semaphore a;
        Semaphore b;

        public FooBar(int n) {
            a=new Semaphore(1);
            b=new Semaphore(0);
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                a.acquire();
                printFoo.run();
                b.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                b.acquire();
                printBar.run();
                a.release();
            }
        }
    }
}
