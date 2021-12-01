package leetcode.leetcode12;

import java.util.PriorityQueue;

public class Leetcode1199 {

    public int findInteger(int k, int digit1, int digit2) {
        PriorityQueue<Integer> q=new PriorityQueue<>((o1,o2)->{
            return o1-o2;
        });

        q.add(digit1);
        q.add(digit2);

        while(!q.isEmpty()){
            int cur=q.poll();
            if(cur%k==0&&cur>k)
                return cur;
            if(cur==0)
                continue;
            long num1=cur* 10L +digit1;
            if(num1<=Integer.MAX_VALUE)
                q.add((int) num1);
            long num2=cur* 10L +digit2;
            if(num2<=Integer.MAX_VALUE)
                q.add((int) num2);
        }
        return -1;
    }
}
