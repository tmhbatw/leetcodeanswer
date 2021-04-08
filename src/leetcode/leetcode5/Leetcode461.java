package leetcode.leetcode5;

public class Leetcode461 {
    /*Description
    * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
    * 给出两个整数 x 和 y，计算它们之间的汉明距离。
    * */

    public int hammingDistance(int x, int y) {
        x^=y;
        int result=0;
        for(int i=0;i<32;i++){
            if(((x>>i)&1)==1)
                result++;
        }
        return result;
    }
}
