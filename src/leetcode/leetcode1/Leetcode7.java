package leetcode.leetcode1;

public class Leetcode7 {
    /*Description
    *给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
    * */

    public int reverse(int x) {
        Long result=0L;
        boolean flag=x>=0;
        x=Math.abs(x);
        while(x>0){
            result*=10;
            result+=x%10;
            x/=10;
        }
        if(result>Integer.MAX_VALUE)
            return 0;
        return (int)(flag?result:-result);
    }
}
