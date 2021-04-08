package leetcode.leetcode4;

public class Leetcode397 {
    /*Description
    * 给定一个正整数n ，你可以做如下操作：
    * 如果n是偶数，则用n / 2替换n
    * 如果n是奇数，则可以用n + 1或n - 1替换n 。
    * n变为 1 所需的最小替换次数是多少？
    * */

    public int integerReplacement(int n) {
        if(n==Integer.MAX_VALUE)
            return 32;
        if(n==1)
            return 0;
        if(n%2==0)
            return 1+integerReplacement(n/2);
        return 1+Math.min(integerReplacement(n-1),integerReplacement(n+1));
    }
}
