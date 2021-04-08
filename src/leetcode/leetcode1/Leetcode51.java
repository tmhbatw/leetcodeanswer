package leetcode.leetcode1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode51 {
    /*Description
    *  皇后问题研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
    * 给定一个整数 n，返回所有不同的n皇后问题的解决方案。
    * 每一种解法包含一个明确的n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位
    * */

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        recursion(result,new char[n][n],0,n);
        return result;
    }

    private void recursion(List<List<String>> result,char[][] res,int index,int n){
        if(index==n){
            List<String> curRes=new ArrayList<>();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(res[i][j]!='Q')
                        res[i][j]='.';
                }
                curRes.add(new String(res[i]));
            }
            result.add(curRes);
            return;
        }
        for(int i=0;i<n;i++){
            if(res[index][i]!='.'){
                char[][] curRes=new char[n][n];
                for(int j=0;j<n;j++)
                    curRes[j]=res[j].clone();
                curRes[index][i]='Q';
                for(int k=index+1;k<n;k++)
                    curRes[k][i]='.';
                for(int k=index+1,j=i+1;k<n&&j<n;k++,j++)
                    curRes[k][j]='.';
                for(int k=index+1,j=i-1;k<n&&j>=0;k++,j--)
                    curRes[k][j]='.';
                //System(curRes);
                recursion(result,curRes,index+1,n);
            }
        }
    }

    private void System(char[][] cur){
        for(char[] curr:cur) {
            System.out.println(Arrays.toString(cur));
        }
    }

    public static void main(String[] args){
        List<List<String>> result=new Leetcode51().solveNQueens(4);
        System.out.println(result.size());
        for(List<String> cur:result){
            for(String curr:cur)
                System.out.println(curr);
        }
    }
}
