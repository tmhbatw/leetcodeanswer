package leetcode8;

import java.util.HashMap;
import java.util.Map;

public class Leetcode760 {
    /*Description
    *给定两个列表 Aand B，并且 B 是 A 的变位（即 B 是由 A 中的元素随机排列后组成的新列表）。
    * 我们希望找出一个从 A 到 B 的索引映射 P 。一个映射 P[i] = j 指的是列表 A 中的第 i 个元素出现于列表 B 中的第 j 个元素上。
    * 列表 A 和 B 可能出现重复元素。如果有多于一种答案，输出任意一种。
    * */

    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<B.length;i++)
            map.put(B[i],i);
        int[] res=new int[A.length];
        for(int i=0;i<A.length;i++){
            res[i]=map.get(A[i]);
        }
        return res;
    }
}
