package interview;

public class Problem16_5 {
    /*Description
    * 设计一个算法，算出 n 阶乘有多少个尾随零。
    * */

    public int trailingZeroes(int n) {
        int res=0;
        while(n>0){
            n/=5;
            res+=n;
        }
        return res;
    }
}
