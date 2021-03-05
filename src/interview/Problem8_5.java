package interview;

public class Problem8_5 {
    /*Description
    * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
    * */

    public int multiply(int A, int B) {
        if(B==0)
            return 0;
        int res=(B&1)==1?A:0;
        return multiply(A<<1,B>>1)+res;
    }
}
