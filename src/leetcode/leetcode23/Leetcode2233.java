package leetcode.leetcode23;

import java.util.PriorityQueue;

public class Leetcode2233{

    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:nums)
            pq.add(num);

        while(k-->0){
            pq.add(pq.poll()+1);
        }
        long cur = 1;
        int mod=1000000007;

        for(int num:pq){
            cur *= num;
            cur%=mod;
        }
        return (int) cur;
    }

    public static void main(String[] args){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        System.out.println(pq);
    }
}
