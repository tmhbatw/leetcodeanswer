package leetcode.leetcode23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode2208 {

    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq=new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0.0;
        for(int num:nums){
            sum += num;
            pq.add((double) num);
        }

        sum/=2;
        double cur= 0.0;
        int result = 0;
        while(cur<sum){
            result ++;
            double max=pq.poll();
            cur+=max/2;
            pq.add(max/2);
        }

        return result;
    }
}
