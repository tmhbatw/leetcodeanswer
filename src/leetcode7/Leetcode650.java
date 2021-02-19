package leetcode7;

import java.util.HashMap;
import java.util.Map;

public class Leetcode650 {
    /*Description
    * 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
    * Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)
    * Paste (粘贴) : 你可以粘贴你上一次复制的字符。
    * 给定一个数字n。你需要使用最少的操作次数，在记事本中打印出恰好n个 'A'。输出能够打印出n个 'A' 的最少操作次数。
    * */

    Map<Integer,Integer> map=new HashMap<>();
    public int minSteps(int n) {
        if(map.containsKey(n))
            return map.get(n);
        if(n==1)
            return 0;
        int result=n;
        if(n%2==0)
            result=Math.min(result,minSteps(n/2)+2);
        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0) {
                result = Math.min(result, minSteps(n / i)+i);
            }
        }
        map.put(n,result);
        return result;
    }
}
