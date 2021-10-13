package leetcode.leetcode9;

import java.util.*;

public class Leetcode819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] word=paragraph.split(" ");
        Map<String,Integer> map=new HashMap<>();
        for(String c:word){
            List<String> list=getList(c.toLowerCase());
            for(String cur:list)
                map.put(cur,map.getOrDefault(cur,0)+1);
        }
        String result="";
        int number=0;
        Set<String> set = new HashSet<>(Arrays.asList(banned));
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            if(set.contains(entry.getKey()))
                continue;
            if(entry.getValue()>number){
                number=entry.getValue();
                result=entry.getKey();
            }
        }
        return result;
    }

    public List<String> getList(String cur){
        List<String> list=new ArrayList<>();
        for(int i=0;i<cur.length();i++){
            if(cur.charAt(i)>'z'||cur.charAt(i)<'a')
                continue;
            int start=i;
            while(i+1<cur.length()&&cur.charAt(i+1)<='z'&&cur.charAt(i+1)>='a'){
                i++;
            }
            list.add(cur.substring(start,i+1));
        }
        return list;
    }
}
