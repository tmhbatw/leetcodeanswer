package forOffer;

public class forOffer65 {
    /*Description
    * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
    * */

    public int add(int a, int b) {
        if(a==0)
            return b;
        if(b==0)
            return a;
        return add(a^b,(a&b)<<1);
    }
}
