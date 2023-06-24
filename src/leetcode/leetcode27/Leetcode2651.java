package leetcode.leetcode27;

public class Leetcode2651 {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return arrivalTime + delayedTime >= 24 ? arrivalTime + delayedTime - 24 : arrivalTime + delayedTime;
    }

}
