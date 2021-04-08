package leetcode.leetcode5;

import java.util.ArrayList;
import java.util.List;

public class Leetcode412 {
    /*Description
    * 写一个程序，输出从 1 到 n 数字的字符串表示。
    * 1. 如果n是3的倍数，输出“Fizz”；
    * 2. 如果n是5的倍数，输出“Buzz”；
    * 3.如果n同时是3和5的倍数，输出 “FizzBuzz”。
    * */

    public List<String> fizzBuzz(int n) {
        List<String> result=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%3==0&&i%5==0)
                result.add("FizzBuzz");
            else if(i%3==0)
                result.add("Fizz");
            else if(i%5==0)
                result.add("Buzz");
            else
                result.add(i+"");
        }
        return result;
    }
}
