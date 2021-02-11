package leetcode6;

public class Leetcode507 {
    /*Description
    * 对于一个正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
    * 给定一个整数n，如果是完美数，返回 true，否则返回 false
    * */

    public boolean checkPerfectNumber(int num) {
        if(num==1)
            return false;
        int result=0;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0)
                result+=i+num/i;
        }
        return result+1==num;
    }
}
