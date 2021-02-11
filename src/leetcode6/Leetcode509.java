package leetcode6;

public class Leetcode509 {
    /*Description
    * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。
    * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
    * */

    public int fib(int n) {
        if(n<=1)
            return n;
        int pre1=0,pre2=1;
        int result=0;
        for(int i=1;i<n;i++){
            result=pre1+pre2;
            int temp=pre2;
            pre2=result;
            pre1=temp;
        }
        return result;
    }
}
