package leetcode3;

import java.util.HashSet;
import java.util.Set;

public class Leetcode202 {
    /*Description
    * 编写一个算法来判断一个数 n 是不是快乐数。
    * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
    * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
    * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
    * */

    public boolean isHappy(int n) {
        Set<Integer> reached=new HashSet<>();
        while(!reached.contains(n)){
            reached.add(n);
            if(n==1)
                return true;
            n=getNext(n);
        }
        return false;
    }

    private int getNext(int n){
        int res=0;
        while(n!=0){
            int curr=n%10;
            res+=curr*curr;
            n/=10;
        }
        return res;
    }
}
