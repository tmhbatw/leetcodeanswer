package forOffer;

public class forOffer16 {
    /*Description
    * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
    * */

    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        if(n<0){
            if(n==Integer.MIN_VALUE)
                return myPow(x,n+1)/x;
            x=1/x;
            n=-n;
        }
        double res=1;
        double base=x;
        while(n>0){
            if(n%2==1)
                res*=base;
            n/=2;
            base*=base;
        }
        return res;
    }
}
