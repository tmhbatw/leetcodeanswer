package leetcode.leetcode9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map=new HashMap<>();
        for(String domain:cpdomains){
            String[] s=domain.split(" ");
            int time=Integer.parseInt(s[0]);
            String[] ip=s[1].split("\\.");
            String cur=ip[ip.length-1];
            map.put(cur,map.getOrDefault(cur,0)+time);
            for(int j=ip.length-2;j>=0;j--){
                cur=ip[j]+"."+cur;
                map.put(cur,map.getOrDefault(cur,0)+time);
            }
        }
        List<String> list=new ArrayList<>();
        for(String key:map.keySet()){
            list.add(map.get(key)+" "+key);
        }
        return list;
    }
}
