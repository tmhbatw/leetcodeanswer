package leetcode1;

public class Leetcode29 {
    /*Description
    * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
    * 返回被除数dividend除以除数divisor得到的商。
    * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
    * 提示：
    * 被除数和除数均为 32 位有符号整数。
    * 除数不为0。
    * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2的31次方, 2的31次方− 1]。本题中，如果除法结果溢出，则返回 231− 1。
    * */

    public int divide(int dividend, int divisor) {
        boolean positive=true;

        if(dividend<0){
            if(dividend==Integer.MIN_VALUE){
                if(divisor==dividend)
                    return 1;
                if(divisor==-1)
                    return Integer.MAX_VALUE;
                return divisor>0?-1+divide(dividend+divisor,divisor):
                        1+divide(dividend-divisor,divisor);
            }
            dividend=-dividend;
            positive= false;
        }
        if(divisor<0){
            if(divisor==Integer.MIN_VALUE)
                return 0;
            divisor=-divisor;
            positive= !positive;
        }
        int length=Integer.toBinaryString(divisor).length();
        int result=0;
        for(int i=31-length;i>=0;i--){
            int curDivisor=divisor<<i;
            if(dividend>=curDivisor){
                result+=(1<<i);
               dividend-=curDivisor;
            }
        }
        return positive?result:-result;
    }
}
