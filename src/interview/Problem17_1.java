package interview;

public class Problem17_1 {
    /*Description
    * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
    * */

    public int add(int a, int b) {
        if(a==0)
            return b;
        if(b==0)
            return a;
        return add((a&b)<<1,a^b);

    }
}
