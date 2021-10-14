package leetcode.leetcode9;

import java.util.*;

public class Leetcode884 {

    public String[] uncommonFromSentences(String s1, String s2) {
        String[] ss1=s1.split(" ");
        String[] ss2=s2.split(" ");
        Set<String> list=new HashSet<>();
        addString(ss1,ss2,list);
        addString(ss2,ss1,list);
        String[] result=new String[list.size()];
        int index=0;
        for(String cur:list)
            result[index++]=cur;
        return result;
    }

    private void addString(String[] ss1,String[] ss2,Set<String> list){
        Set<String> set1=new HashSet<>(Arrays.asList(ss1));
        Map<String,Integer> map=new HashMap<>();
        for(String cur:ss2){
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(entry.getValue()==1&&!set1.contains(entry.getKey()))
                list.add(entry.getKey());
        }
    }
}
