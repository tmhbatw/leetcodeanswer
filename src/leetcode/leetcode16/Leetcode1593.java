package leetcode.leetcode16;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1593 {


    int result=0;
    public int maxUniqueSplit(String s) {
        dfs(0,s,new HashSet<>(),0);
        return result;
    }

    private void dfs(int index, String s, Set<String> set, int cur){
        if(index==s.length()){
            result=Math.max(cur,result);
        }
        for(int i=index+1;i<=s.length();i++){
            String curS=s.substring(index,i);
            if(set.contains(curS))
                continue;
            set.add(curS);
            dfs(i,s,set,cur+1);
            set.remove(curS);
        }
    }
}
