package leetcode.leetcode17;

import java.sql.Array;
import java.util.*;

public class Leetcode1604 {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String,List<String>> map=new HashMap<>();
        for(int i=0;i<keyName.length;i++){
            map.putIfAbsent(keyName[i],new ArrayList<>());
            map.get(keyName[i]).add(keyTime[i]);
        }

        List<String> result=new ArrayList<>();
        for(String key:map.keySet()){
            List<String> l=map.get(key);
            Collections.sort(l);
            for(int i=0;i<l.size()-2;i++){
                if(getTime(l.get(i+2))-getTime(l.get(i))<=60){
                    result.add(key);
                    break;
                }

            }
        }
        Collections.sort(result);
        return result;
    }

    private int getTime(String cur){
        int hour=(cur.charAt(0)-'0')*10+cur.charAt(1);
        int min=(cur.charAt(3)-'0')*10+cur.charAt(4);
        return hour*60+min;
    }

}
