package leetcode4;

public class Leetcode343 {
    /*Description
    * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
    * */

    public int integerBreak(int n) {
        if(n<=3)
            return n-1;
        if(n%3==0)
            return (int) Math.pow(3,n/3);
        if(n%3==1)
            return (int)Math.pow(3,(n-2)/3)*4;
        return (int)Math.pow(3,n/3)*2;
    }
}
