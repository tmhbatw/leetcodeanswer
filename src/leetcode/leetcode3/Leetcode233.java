package leetcode.leetcode3;

public class Leetcode233 {
    /*Description
    *给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
    * */
    public int countDigitOne(int n) {
        long number=10;
        int result=0;
        while(n>=number){
            result+=(n/number)*(number/10);
            result+=Math.min(Math.max(n%number-number/10+1,0),number/10);
            number*=10;
        }
        return (int)(result+Math.min(n-number/10+1,number/10));
    }
    public static void main(String[] args){
        System.out.println(new Leetcode233().countDigitOne(101));
    }


}
