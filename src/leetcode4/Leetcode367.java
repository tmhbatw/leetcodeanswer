package leetcode4;

public class Leetcode367 {
    /*Description
    * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
    * 说明：不要使用任何内置的库函数，如  sqrt。
    * */

    public boolean isPerfectSquare(int num) {
        if(num<=0)
            return false;
        int start=0;
        while(true){
            if((long)start*start>num)
                return false;
            if(start*start==num)
                return true;
            start++;
        }
    }
}
