package forOffer;

public class forOffer15 {
    /*Description
    * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。
    * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
    * */

    public int hammingWeight(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            res+=(n>>i)&1;
        }
        return res;
    }
}
