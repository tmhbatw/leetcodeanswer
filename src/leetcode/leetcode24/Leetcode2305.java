package leetcode.leetcode24;

import java.util.Arrays;

public class Leetcode2305 {

    int result =Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        dfs(new int[k],0,cookies,0);
        return result;
    }

    private void dfs(int[] child,int i,int[] cookies,int cur){
        if(cur>result)
            return;

        if(i==cookies.length){
            result = Math.min(result,cur);
            return ;
        }

        int curCookie = cookies[i++];
        for(int j=0;j<child.length;j++){
            child[j]+=curCookie;
            dfs(child,i,cookies,Math.max(cur,child[j]));
            child[j] -= curCookie;
        }
    }

}
