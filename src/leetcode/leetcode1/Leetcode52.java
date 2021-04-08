package leetcode.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode52 {
    /*Description
    *n皇后问题研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    * 上图为 8 皇后问题的一种解法。
    * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
    * */

    public int totalNQueens(int n) {
        return recursion(new boolean[n][n],0,n);
    }

    private int recursion(boolean[][] res,int index,int n){
        if(index==n)
            return 1;
        int result=0;
        for(int i=0;i<n;i++){
            if(!res[index][i]){
                List<Integer> list=new ArrayList<>();
                for(int j=index+1;j<n;j++) {
                    if(!res[j][i]) {
                        res[j][i] = true;
                        list.add(j);
                        list.add(i);
                    }
                }
                for(int j=index+1,k=i+1;j<n&&k<n;j++,k++) {
                    if(!res[j][k]) {
                        res[j][k] = true;
                        list.add(j);
                        list.add(k);
                    }
                }
                for(int j=index+1,k=i-1;j<n&&k>=0;j++,k--) {
                    if(!res[j][k]) {
                        res[j][k] = true;
                        list.add(j);
                        list.add(k);
                    }
                }
                int curRes=recursion(res,index+1,n);
                result+=curRes;
                //回溯
                for(int j=0;j<list.size();j+=2)
                    res[list.get(j)][list.get(j+1)]=false;
                list.clear();
            }
        }
        return result;
    }

    private void System(boolean[][] cur){
        for(boolean[] curr:cur)
            System.out.println(Arrays.toString(curr));
        System.out.println();
    }

    public static void main(String[] args){
        System.out.println(new Leetcode52().totalNQueens(5));
    }
}
