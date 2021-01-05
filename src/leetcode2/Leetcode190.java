package leetcode2;

public class Leetcode190 {
    /*Description
    *颠倒给定的 32 位无符号整数的二进制位。
    * */

    public int reverseBits(int n) {
        boolean negative=n%2==1;
        n/=2;
        int res=0;
        int number=(int)Math.pow(2,30);
        System.out.println(number);
        while(n!=0){
            int cur=n%2;
            if(cur==1){
                res+=number;
            }
            number/=2;
            n/=2;
        }
        return negative?Integer.MIN_VALUE+res:res;
    }
}
