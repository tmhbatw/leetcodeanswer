package leetcode.leetcode8;

import java.util.*;

public class Leetcode721 {

    int index=0;
    private String getId(){
        return "id"+(index++);
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,String> map=new HashMap<>();
        Map<String,String> idToName=new HashMap<>();
        for(List<String> list:accounts){
            String uniqueId=getId();
            map.put(uniqueId,uniqueId);
            idToName.put(uniqueId,list.get(0));
            for(int i=1;i<list.size();i++){
                if(map.containsKey(list.get(i))){
                    String realId=getType(map,list.get(i));
                    map.put(getType(map,uniqueId),realId);
                }else{
                    map.put(list.get(i),getType(map,uniqueId));
                }
            }
        }

        Map<String,List<String>> res=new HashMap<>();
        for(String key:map.keySet()){
            if(key.startsWith("id"))
                continue;
            String id=getType(map,key);
            res.putIfAbsent(id,new ArrayList<>());
            res.get(id).add(key);
        }


        List<List<String>> result=new ArrayList<>();
        for(String id:res.keySet()){
            List<String> l=new ArrayList<>();
            l.add(idToName.get(id));
            Collections.sort(res.get(id));
            l.addAll(res.get(id));
            result.add(l);
        }
        return result;
    }


    private String getType(Map<String,String> map,String cur){
        if(map.get(cur).equals(cur))
            return cur;
        return getType(map,map.get(cur));
    }
}
