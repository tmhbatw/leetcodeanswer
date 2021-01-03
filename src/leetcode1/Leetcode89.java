package leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Leetcode89 {
    /*Description
    * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
    * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
    * 格雷编码序列必须以 0 开头。
    * */

    //格雷编码的生成过程为i^(i/2)
    public List<Integer> grayCode(int n) {
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<1<<n;i++)
            result.add(i^i>>1);
        return result;
    }

    public static void main(String[] args){
        System.out.println(0^0);
    }
}
