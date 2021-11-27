package leetcode.leetcode13;

import java.util.concurrent.Semaphore;

public class Leetcode1226 {

    class DiningPhilosophers {

        Semaphore[] semaphores;
        Semaphore change;

        public DiningPhilosophers() {
            this.semaphores=new Semaphore[5];
            for(int i=0;i<5;i++)
                semaphores[i]=new Semaphore(1);
            this.change=new Semaphore(1);
        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {

            int left=philosopher;
            int right=(philosopher+1)%5;

            change.acquire();
            semaphores[left].acquire();
            semaphores[right].acquire();
            change.release();
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            semaphores[left].release();
            semaphores[right].release();
        }
    }
}
