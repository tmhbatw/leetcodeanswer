package leetcode.leetcode10;

import datastructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode958 {

    public int kthGrammar(int n, int k) {
        if(k==1)
            return 0;
        for(int i=30;i>=0;i--){
            if(k>(1<<i))
                return 1-kthGrammar(n,k-(1<<i));
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(1<<31);
    }
}
