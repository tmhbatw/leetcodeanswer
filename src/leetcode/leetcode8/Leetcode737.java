package leetcode.leetcode8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode737 {

    public boolean areSentencesSimilarTwo(String[] sentence1,
                                          String[] sentence2,
                                          List<List<String>> similarPairs) {
        if(sentence1.length!=sentence2.length)
            return false;
        Union u=new Union();
        for(List<String> l:similarPairs){
            u.map.putIfAbsent(l.get(0),l.get(0));
            u.map.putIfAbsent(l.get(1),l.get(1));
            u.union(l.get(0),l.get(1));
        }
        for(int i=0;i<sentence1.length;i++){
            if(!u.isSimilar(sentence1[i],sentence2[i]))
                return false;
        }
        return true;
    }

    class Union{
        Map<String,String> map;
        public Union(){
            map=new HashMap<>();
        }

        private boolean isSimilar(String s1,String s2){
            if(s1.equals(s2))
                return true;
            if(!map.containsKey(s1)||!map.containsKey(s2))
                return false;
            return getType(s1).equals(getType(s2));
        }

        private String getType(String s){
            if(map.get(s).equals(s))
                return s;
            return getType(map.get(s));
        }

        private void union(String s1,String s2){
            String t1=getType(s1),t2=getType(s2);
            if(t1.equals(t2))
                return;
            map.put(t2,t1);
        }
    }
}
