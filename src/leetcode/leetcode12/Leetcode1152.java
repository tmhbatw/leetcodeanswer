package leetcode.leetcode12;

import javax.crypto.AEADBadTagException;
import java.sql.Array;
import java.util.*;

public class Leetcode1152 {

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Event>> map=new HashMap<>();
        for(int i=0;i<username.length;i++){
            map.putIfAbsent(username[i],new ArrayList<>());
            map.get(username[i]).add(new Event(timestamp[i],website[i]));
        }

        Map<String,Integer> res = new HashMap<>();
        for(String key:map.keySet()){
            List<Event> list=map.get(key);
            list.sort(Comparator.comparingInt(o -> o.timestamp));

            Set<String> set=new HashSet<>();
            for(int i=0;i<list.size();i++){
                for(int j=i+1;j<list.size();j++){
                    for(int k=j+1;k<list.size();k++){
                        set.add(list.get(i).website+" "+list.get(j).website
                                +" "+list.get(k).website);
                    }
                }
            }
            for(String cur:set)
                res.put(cur,res.getOrDefault(cur,0)+1);
        }

        String result = "";
        int count = 0;
        for(String key:res.keySet()){
            if(res.get(key)>count||res.get(key)==count&&key.compareTo(result)<0){
                result = key;
                count = res.get(key);
            }
        }

        List<String> l=new ArrayList<>();
        for(String cur:result.split(" "))
            l.add(cur);
        return l;
    }

    class Event{
        int timestamp;
        String website;

        public Event(int timestamp,String website){
            this.timestamp = timestamp;
            this.website = website;
        }
    }
}
