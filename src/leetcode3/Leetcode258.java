package leetcode3;

public class Leetcode258 {
    /*Description
    * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     * */

    public int addDigits(int num) {
        return (num-1)%9+1;
    }
}
