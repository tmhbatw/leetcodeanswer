package leetcode.leetcode7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class Leetcode635 {

    class LogSystem {

        TreeMap<String,Integer> map;
        public LogSystem() {
            this.map=new TreeMap<>();
        }

        public void put(int id, String timestamp) {
            map.put(timestamp,id);
        }

        public List<Integer> retrieve(String start, String end, String granularity) {
            List<Integer> result=new ArrayList<>();
            for(String key:map.keySet()){
                if(isBig(start,key,granularity)&&isBig(key,end,granularity))
                    result.add(map.get(key));
            }
            return result;
        }

        private boolean isBig(String start,String s,String g){
            String[] s1=start.split(":");
            String[] s2=s.split(":");
            int index=getType(g);

            for(int i=0;i<=index;i++){
                int i1=Integer.parseInt(s1[i]);
                int i2=Integer.parseInt(s2[i]);
                if(i2>i1)
                    return true;
                if(i2<i1)
                    return false;
            }
            return true;
        }

        private int getType(String g){
            switch (g){
                case "Year":
                    return 0;
                case "Month":
                    return 1;
                case "Day":
                    return 2;
                case "Hour":
                    return 3;
                case "Minute":
                    return 4;
                default:
                    return 5;
            }
        }
    }
}
