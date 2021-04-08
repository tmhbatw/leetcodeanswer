package leetcode.leetcode2;

public class Leetcode172 {
    /*Description
    * 给定一个整数 n，返回 n! 结果尾数中零的数量。
    * */
    public int trailingZeroes(int n) {
        int result=0;
        while(n!=0){
            n/=5;
            result+=n;
        }
        return result;
    }

}
