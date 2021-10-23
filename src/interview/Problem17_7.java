package interview;

import java.util.HashMap;
import java.util.Map;

public class Problem17_7 {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String,String> type=new HashMap<>();
        for(String relationship:synonyms){
            String res=relationship.substring(1,relationship.length()-1);
            String[] t=res.split(",");
            String t1=t[0];
            String t2=t[1];

            type.putIfAbsent(t1,t1);
            type.putIfAbsent(t2,t2);

            String type1=getType(type,t1);
            String type2=getType(type,t2);
            if(type1.equals(type2))
                continue;
            if(type2.compareTo(type1)<0){
                String temp=type1;
                type1=type2;
                type2=temp;
            }
            type.put(type2,type1);
        }

        Map<String,Integer> result=new HashMap<>();
        for(String name:names){
            String[] s=name.split("\\(");
            String n=s[0];
            int num=Integer.parseInt(s[1].substring(0,s[1].length()-1));
            String t=getType(type,n);
            result.put(t,result.getOrDefault(t,0)+num);
        }

        String[] res=new String[result.size()];
        int index=0;
        for(Map.Entry<String,Integer> entry:result.entrySet()){
            res[index++]=entry.getKey()+"("+entry.getValue()+")";
        }
        return res;
    }

    private String getType(Map<String,String> type,String cur){
        if(!type.containsKey(cur)||type.get(cur).equals(cur))
            return cur;
        return getType(type,type.get(cur));
    }
}
