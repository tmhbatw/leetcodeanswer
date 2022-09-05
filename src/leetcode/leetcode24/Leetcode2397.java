package leetcode.leetcode24;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2397 {

    int result=0;
    List<Integer> list=new ArrayList<>();
    public int maximumRows(int[][] mat, int cols) {
        for(int[] m:mat){
            int cur = 0;
            for(int num:m){
                cur=2*cur+num;
            }
            list.add(cur);
        }


        dfs(0,cols,mat[0].length,0);

        return result;
    }
    private void dfs(int cur,int cols,int n,int i){
        if(i==n){
            int curCount = 0;
            for(int l:list){
                if((cur&l) == l){
                    curCount++;
                }
            }
            result=Math.max(result,curCount);
            return;
        }

        cur*=2;
        dfs(cur,cols,n,i+1);
        if(cols>0){
            dfs(cur+1,cols-1,n,i+1);
        }
    }

}
