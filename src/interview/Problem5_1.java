package interview;

public class Problem5_1 {
    /*Description
    * 给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。
    * 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。
    * 具体插入过程如图所示。
    * */

    public int insertBits(int N, int M, int i, int j) {
        for(int l=i;l<=j;l++){
            if(((N>>l)&1)==1)
                N-=1<<l;
        }
        N+=(M<<i);
        return N;
    }
}
