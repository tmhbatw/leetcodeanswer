package leetcode.leetcode16;

import java.util.LinkedList;

public class Leetcode1536 {

    public int minSwaps(int[][] grid) {
        LinkedList<Integer> l=new LinkedList<>();
        for(int[] g:grid){
            int j=g.length-1;
            for(;j>=0;j--){
                if(g[j]==1)
                    break;
            }
            j=g.length-1-j;
            l.add(j);
        }

        int result=0;
        for(int j=grid.length-1;j>=1;j--){
            boolean flag=true;
            for(int i=0;i<l.size();i++){
                if(l.get(i)>=j){
                    result+=i;
                    l.remove(i);
                    flag=false;
                    break;
                }
            }
            if(flag)
                return -1;
        }

        return result;
    }
}
