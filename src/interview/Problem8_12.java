package interview;

import java.util.ArrayList;
import java.util.List;

public class Problem8_12 {
    /*Description
    *设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。
    * 这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
    * */

    boolean[] reached1;
    boolean[] reached2;
    boolean[] reached3;
    public List<List<String>> solveNQueens(int n) {
        reached1=new boolean[n];
        reached2=new boolean[n*2];
        reached3=new boolean[n*2];
        char[][] c=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                c[i][j]='.';
        }
        List<List<String>> result=new ArrayList<>();
        dfs(0,c,n,result);
        return result;
    }

    private void dfs(int index,char[][] c,int n,List<List<String>> result){
        if(index==n){
            List<String> list=new ArrayList<>();
            for(char[] cur:c){
                list.add(new String(cur));
            }
            result.add(list);
            return;
        }
        for(int i=0;i<n;i++){
            if(!reached1[i]&&!reached2[i+index]&&!reached3[i-index+n]){
                reached1[i]=true;
                reached2[i+index]=true;
                reached3[i-index+n]=true;
                c[index][i]='Q';
                dfs(index+1,c,n,result);
                c[index][i]='.';
                reached1[i]=false;
                reached2[i+index]=false;
                reached3[i-index+n]=false;
            }
        }
    }
}
