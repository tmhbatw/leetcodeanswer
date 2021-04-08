package leetcode.leetcode8;

public class Leetcode762 {
    /*Description
    * 给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
    * （注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
    * */

    public int countPrimeSetBits(int L, int R) {
        int result=0;
        for(int i=L;i<=R;i++){
            int oneVal=getOneVal(i);
            if(isPrime(oneVal))
                result++;
        }
        return result;
    }

    private boolean isPrime(int cur){
        switch (cur){
            case 2:
            case 3:
            case 5:
            case 7:
            case 11:
            case 13:
            case 17:
            case 19:
            case 23:
            case 29:
            case 31:
                return true;
            default:
                return false;
        }
    }

    private int getOneVal(int cur){
        int res=0;
        for(int i=0;i<32;i++){
            if((cur>>i&1)==1)
                res++;
        }
        return res;
    }
}
