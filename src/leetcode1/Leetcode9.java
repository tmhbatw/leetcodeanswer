package leetcode1;

public class Leetcode9 {
    /*Description
    *判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    * */

    /*Description
    * 你能不将整数转为字符串来解决这个问题吗？
    * */

    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        String xx=String.valueOf(x);
        int length=xx.length();
        for(int i=0;i<length/2;i++){
            if(xx.charAt(i)!=xx.charAt(length-i-1))
                return false;
        }
        return true;
    }
}
