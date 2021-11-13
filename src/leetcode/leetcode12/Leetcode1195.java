package leetcode.leetcode12;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Leetcode1195 {

    class FizzBuzz {
        private int n;
        Semaphore a=new Semaphore(1);
        Semaphore b=new Semaphore(0);
        Semaphore c=new Semaphore(0);
        Semaphore d=new Semaphore(0);

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for(int i=1;i<=n;i++){
                b.acquire();
                if(i%3==0&&i%5!=0){
                    printFizz.run();
                }
                c.release();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for(int i=1;i<=n;i++){
                c.acquire();
                if(i%5==0&&i%3!=0)
                    printBuzz.run();
                d.release();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for(int i=1;i<=n;i++){
                a.acquire();
                if(i%15==0)
                    printFizzBuzz.run();
                b.release();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for(int i=1;i<=n;i++){
                d.acquire();
                if(i%3!=0&&i%5!=0)
                    printNumber.accept(i);
                a.release();
            }
        }
    }
}
