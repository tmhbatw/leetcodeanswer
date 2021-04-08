package leetcode.leetcode3;

import java.util.PriorityQueue;

public class Leetcode264 {
    /*Description
    * 编写一个程序，找出第 n 个丑数。
    * 丑数就是质因数只包含 2, 3, 5 的正整数。
    * */

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> p=new PriorityQueue<>();
        p.add(1L);
       while(--n>0){
           Long cur=p.poll();
           while(!p.isEmpty()&& p.peek().equals(cur))
               p.poll();
           p.add(cur*2);
           p.add(cur*3);
           p.add(cur*5);
       }
       long result=p.poll();
       return (int)result;
    }
}
