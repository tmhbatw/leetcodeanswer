package leetcode.leetcode9;

import java.util.Arrays;

public class Leetcode853 {

    class Car{
        int position;
        int speed;
        public Car(int position,int speed){
            this.position=position;
            this.speed=speed;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars=new Car[position.length];
        for(int i=0;i<position.length;i++){
            cars[i]=new Car(position[i],speed[i]);
        }

        Arrays.sort(cars,(o1,o2)->{
            return o2.position-o1.position;
        });

        int result=0;
        double time=0;
        for(Car car :cars){
            double curTime=(target-car.position)*1.0/car.speed;
            if(curTime>time){
                time=curTime;
                result++;
            }
        }

        return result;
    }
}
