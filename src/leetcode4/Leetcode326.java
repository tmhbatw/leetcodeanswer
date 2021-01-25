package leetcode4;

public class Leetcode326 {
    /*Description
    * 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
    * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
    * */

    public boolean isPowerOfThree(int n) {
        if(n<=0)
            return false;
        while(n>1){
            if(n%3!=0)
                return false;
            n/=3;
        }
        return true;
    }
}
