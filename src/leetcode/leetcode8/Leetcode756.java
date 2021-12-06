package leetcode.leetcode8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode756 {
    private boolean result=false;
    Map<Integer,List<Character>> map=new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for(String s:allowed){
            int type=getType(s.charAt(0),s.charAt(1));
            map.putIfAbsent(type,new ArrayList<>());
            map.get(type).add(s.charAt(2));
        }
        dfs(bottom,"",0);
        return result;
    }

    private void dfs(String bottom,String next,int index){
        if(result)
            return;
        if(bottom.length()==1){
            result=true;
            return;
        }
        if(index==bottom.length()-1){
            dfs(next,"",0);
            return;
        }
        int t=getType(bottom.charAt(index),bottom.charAt(index+1));
        List<Character> l=map.getOrDefault(t,new ArrayList<>());

        for(char n:l){
            dfs(bottom,next+n,index+1);
        }
    }

    private int getType(char a,char b){
        return a*128+b;
    }
}
