package leetcode4;

public class Leetcode372 {
    /*Description
    * 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
    * */

    public int superPow(int a, int[] b) {
        int mod=1337;
        int result=1;
        int curA=a%mod;
        for(int i=b.length-1;i>=0;i--){
            while(b[i]-->0) {
                result *=curA;
                result%=mod;
            }
            int temp=curA;
            for(int j=0;j<9;j++){
                temp*=curA;
                temp%=1337;
            }
            curA=temp;
        }
        return result;
    }
}
