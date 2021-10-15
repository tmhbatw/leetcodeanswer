package leetcode.leetcode13;

import java.util.concurrent.Semaphore;

public class Leetcode1279 {

    class TrafficLight {

        Semaphore a ;
        private boolean road1IsGreen = true;
        public TrafficLight() {
            a=new Semaphore(1);
        }

        public void carArrived(
                int carId,           // ID of the car
                int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
                int direction,       // Direction of the car
                Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
                Runnable crossCar    // Use crossCar.run() to make car cross the intersection
        ) throws InterruptedException {
            a.acquire();

            if((roadId == 1 && !road1IsGreen) || roadId ==2 && road1IsGreen){
                turnGreen.run();
                road1IsGreen = !road1IsGreen;
            }
            crossCar.run();
            a.release();
        }
    }
}
