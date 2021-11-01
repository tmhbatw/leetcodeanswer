package leetcode.leetcode11;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1079 {

    Set<String> set=new HashSet<>();
    public int numTilePossibilities(String tiles) {
        char[] c=tiles.toCharArray();
        boolean[] reached=new boolean[c.length];
        dfs(c,reached,new StringBuilder());
        return set.size();
    }

    private void dfs(char[] c,boolean[] reached,StringBuilder sb){
        if(sb.length()==c.length)
            return;
        for(int i=0;i<c.length;i++){
            if(!reached[i]){
                StringBuilder newSb=new StringBuilder(sb);
                newSb.append(c[i]);
                set.add(newSb.toString());
                reached[i]=true;
                dfs(c,reached,newSb);
                reached[i]=false;
            }
        }
    }
}
