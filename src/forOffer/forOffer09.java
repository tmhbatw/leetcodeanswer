package forOffer;

public class forOffer09 {
    /*Description
    * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
    * */

    public int fib(int n) {
        if(n==0)
            return 0;
        int mod=1000000007;
        int first=0,second=1;
        while(--n>0){
            first+=second;
            first%=mod;
            int temp=first;
            first=second;
            second=temp;
        }
        return second;
    }
}
