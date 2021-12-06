package leetcode.leetcode13;

import java.util.*;

public class Leetcode1258 {

    List<String> result=new ArrayList<>();
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String,String> type=new HashMap<>();
        for(List<String> s:synonyms){
            String s1=s.get(0);
            String s2=s.get(1);

            type.putIfAbsent(s1,s1);
            type.putIfAbsent(s2,s2);

            String t1=getType(type,s1);
            String t2=getType(type,s2);
            if(!t1.equals(t2))
                type.put(t2,t1);
        }
        Map<String,List<String>> map=new HashMap<>();
        for(String key:type.keySet()){
            String t=getType(type,key);
            map.putIfAbsent(t,new ArrayList<>());
            List<String> list=map.get(t);
            list.add(key);
            map.put(key,list);
        }
        dfs(text.split(" "),new StringBuilder(),0,map);
        Collections.sort(result);
        return result;
    }

    private void dfs(String[] text,StringBuilder sb,int index,Map<String,List<String>> m){
        if(index==text.length){
            result.add(sb.substring(1));
        }else{
            if(m.containsKey(text[index])){
                List<String> l=m.get(text[index]);
                for(String n:l){
                    StringBuilder newSb=new StringBuilder(sb);
                    newSb.append(" ").append(n);
                    dfs(text,newSb,index+1,m);
                }
            }else{
                sb.append(" ").append(text[index]);
                dfs(text,sb,index+1,m);
            }
        }
    }

    private String getType(Map<String,String> type,String cur){
        if(type.get(cur).equals(cur))
            return cur;
        return getType(type,type.get(cur));
    }
}
