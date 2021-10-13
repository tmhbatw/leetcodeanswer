package leetcode.leetcode9;

import java.util.ArrayList;
import java.util.List;

public class Leetcode821 {
    /*Description
    *给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。
    * 返回一个整数数组 answer ，其中 answer.length == s.length
    * 且 answer[i] 是 s 中从下标 i 到离它 最近 的字符 c 的 距离 。
    *
    * 两个下标i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。
    * */

    public int[] shortestToChar(String s, char c) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c)
                list.add(i);
        }
        list.add(Integer.MAX_VALUE);

        int index=0;

        int[] res=new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(index==0)
                res[i]=list.get(index)-i;
            else{
                res[i]=Math.min(list.get(index)-i,i-list.get(index-1));
            }

            if(list.get(index)==i)
                index++;
        }

        return res;
    }
}
