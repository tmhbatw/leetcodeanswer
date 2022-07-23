package leetcode.leetcode20;

public class Leetcode1954 {

    /*
    * 边长   数量（结果都要乘四）
    * 0     0          ((1-1)+(1*2-2))*1/2
    * 1     1+2       (3x-3) * x/2
    * 2     2+3+4+3
    * 3     3+4+5+6+4+5    (x+1+2x-1)*(x-1)/2;
    *
    * 6 5  4  3  4  5  6
    *   4  3  2  3  4
    *      2  1  2
    *
    * */
    public long minimumPerimeter(long neededApples) {
        long result = 0;
        long cur = 0;

        while(result<neededApples){
            cur+=2;
            long cal=cur/2;
            result += 4*((3*cal)*(cal+1)/2  + 3*cal*(cal-1)/2);
        }

        return cur*4;
    }

}
