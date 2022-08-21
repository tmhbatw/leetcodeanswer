package lcp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PrimitiveIterator;
import java.util.PriorityQueue;

public class lcp30 {

    public int magicTower(int[] nums) {
        int sum= Arrays.stream(nums).sum();
        if(sum+1<0)
            return -1;

        long cur=1;
        PriorityQueue<Integer> q=new PriorityQueue<>();
        int result=0;
        for(int num:nums){
            if(num<0){
                q.add(num);
            }
            cur+=num;
            if(cur<=0){
                result++;
                cur-=q.poll();
            }
        }

        return result;
    }

}
