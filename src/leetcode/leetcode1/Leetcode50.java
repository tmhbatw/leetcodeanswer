package leetcode.leetcode1;

public class Leetcode50 {
    /*Description
    *实现 pow(x, n) ，即计算 x 的 n 次幂函数。
    * */

    public double myPow(double x, int n) {
        if(n<0){
            x=1/x;
            if(n== Integer.MIN_VALUE)
                return x*myPow(x,Integer.MAX_VALUE);
            n=-n;
        }
        double result=1.0;
        while(n!=0){
            if(n%2==1)
                result*=x;
            n/=2;
            x*=x;
        }
        return result;
    }
}
