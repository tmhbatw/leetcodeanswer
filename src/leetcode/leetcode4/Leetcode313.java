package leetcode.leetcode4;

import java.util.PriorityQueue;

public class Leetcode313 {
    /*Description
    * 编写一段程序来查找第 n 个超级丑数。
    * 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。
    * */

    public int nthSuperUglyNumber(int n, int[] primes) {
        long res=1;
        PriorityQueue<Long> p=new PriorityQueue<>();
        while(--n>0){
            for(int cur:primes){
                p.add(cur*res);
            }
            res=p.poll();
            while(!p.isEmpty()&&p.peek()==res)
                p.poll();
        }
        return (int)res;

    }
}
