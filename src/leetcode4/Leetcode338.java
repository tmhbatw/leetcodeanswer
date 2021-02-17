package leetcode4;

public class Leetcode338 {
    /*Description
    *给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
    * 计算其二进制数中的 1 的数目并将它们作为数组返回。
    * */

    public int[] countBits(int num) {
        int[] n=new int[num+1];
        n[0]=0;
        for(int i=1;i<=num;i++){
            n[i]=n[i/2]+(i%2);
        }
        return n;
    }
}
