package leetcode.leetcode20;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode1962 {

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> q=new PriorityQueue<>(Comparator.reverseOrder());
        int sum=0;
        for(int num:piles){
            sum+=num;
            q.add(num);
        }

        while(k-->0){
            int cur=q.poll();
            sum-=cur/2;
            q.add((cur+1)/2);
        }

        return sum;
    }

}
