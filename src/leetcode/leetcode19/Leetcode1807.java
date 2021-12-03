package leetcode.leetcode19;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode1807 {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map=new HashMap<>();
        for(List<String> list:knowledge){
            map.put(list.get(0),list.get(1));
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                StringBuilder cur=new StringBuilder();
                while(s.charAt(i+1)!=')'){
                    cur.append(s.charAt(++i));
                }
                i++;
                sb.append(map.getOrDefault(cur.toString(),"?"));
            }else
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
