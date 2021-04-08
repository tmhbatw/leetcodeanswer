package leetcode.leetcode5;

import java.util.Arrays;

public class Leetcode455 {
    /*Description
    * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
    * 对每个孩子 i，都有一个胃口值g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
    * 并且每块饼干 j，都有一个尺寸 s[j]。如果 s[j]>= g[i]，我们可以将这个饼干 j 分配给孩子 i ，
    * 这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
    * */

    public int findContentChildren(int[] g, int[] s) {
        if(g==null||s==null)
            return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int index1=g.length-1,index2=s.length-1;
        int result=0;
        while(index1>=0&&index2>=0){
            if(g[index1]<=s[index2]) {
                index1--;
                index2--;
                result++;
            }else
                index1--;
        }
        return result;
    }
}
