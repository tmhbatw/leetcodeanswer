package leetcode.leetcode10;

import java.util.HashMap;
import java.util.Map;

public class Leetcode990 {
    public boolean equationsPossible(String[] equations) {
        Map<Character,Character> type=new HashMap<>();
        for(String e:equations){
            if(e.charAt(1)=='='){
                char c1=e.charAt(0);
                char c2=e.charAt(3);
                type.putIfAbsent(c1,c1);
                type.putIfAbsent(c2,c2);
                char t1=getType(type,c1);
                char t2=getType(type,c2);
                if(t1==t2)
                    continue;
                type.put(t1,t2);
            }
        }
        for(String e:equations){
            if(e.charAt(1)=='!'){

                if(e.charAt(0)==e.charAt(3))
                    return false;
                if(!type.containsKey(e.charAt(0))||!type.containsKey(e.charAt(3)))
                    continue;
                if(getType(type,e.charAt(0))==getType(type,e.charAt(3)))
                    return false;
            }
        }
        return true;
    }


    private char getType(Map<Character,Character> type,char cur){
        if(type.get(cur)==cur)
            return cur;
        return getType(type,type.get(cur));
    }
}
