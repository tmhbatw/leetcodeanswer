package leetcode4;

public class Leetcode371 {
    /*Description
    * 不使用运算符 + 和 - ，计算两整数 a 、b之和。
     * */

    public int getSum(int a, int b) {
        if(b==0)
            return a;
        if(a==0)
            return b;
        int aa=a^b;
        int bb=(a&b)<<1;
        return getSum(aa,bb);
    }
}
