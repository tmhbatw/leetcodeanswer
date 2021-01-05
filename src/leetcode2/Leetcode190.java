package leetcode2;

public class Leetcode190 {
    /*Description
    *颠倒给定的 32 位无符号整数的二进制位。
    * */

    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            res+=((n>>i)&1)<<(31-i);
        }
        return res;
    }

    public static void main(String[] args){
        String s="11111111111111111111111111111101";
        new Leetcode190().reverseBits(Integer.parseInt(s,2));
    }
}
