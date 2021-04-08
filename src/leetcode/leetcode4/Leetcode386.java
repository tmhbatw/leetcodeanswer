package leetcode.leetcode4;

import java.util.*;

public class Leetcode386 {
    /*Description
    * 给定一个整数n, 返回从1到n的字典顺序。
    * 例如，给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
    * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据n小于等于5,000,000。
    * */

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result=new ArrayList<>();
        for(int i=1;i<=n;i++)
            result.add(i);
        Collections.sort(result, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1+"").compareTo(o2+"");
            }
        });
        return result;
    }
}
