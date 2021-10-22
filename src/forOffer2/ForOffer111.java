package forOffer2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForOffer111 {
    public double[] calcEquation(List<List<String>> equations,
                                 double[] values, List<List<String>> queries) {
        Map<String,String> type=new HashMap<>();
        Map<String,Double> value=new HashMap<>();
        int index=0;
        for(List<String> list:equations){
            String s1=list.get(0);
            String s2=list.get(1);

            type.putIfAbsent(s1,s1);
            type.putIfAbsent(s2,s2);
            value.putIfAbsent(s1,1.0);
            value.putIfAbsent(s2,1.0);

            String type1=getType(type,s1);
            String type2=getType(type,s2);
            if(type1.equals(type2))
                continue;

            double val1=getType(value,type,s1);
            double val2=getType(value,type,s2);
            type.put(type2,type1);
            value.put(type2,val1/val2/values[index++]);

        }

        double[] res=new double[queries.size()];
        for(int i=0;i<res.length;i++){
            String s1=queries.get(i).get(0);
            String s2=queries.get(i).get(1);

            if(!type.containsKey(s1)||!type.containsKey(s2)||
                    !getType(type,s1).equals(getType(type,s2)))
                res[i]=-1.0;
            else{
                double val1=getType(value,type,s1);
                double val2=getType(value,type,s2);
                res[i]=val1/val2;
            }

        }
        return res;
    }

    private double getType(Map<String,Double> value,Map<String,String> map, String cur){
        if(map.get(cur).equals(cur))
            return value.get(cur);
        return value.get(cur)*getType(value,map,map.get(cur));
    }

    private String getType(Map<String,String> map,String cur){
        if(!map.get(cur).equals(cur))
            return getType(map,map.get(cur));
        return cur;
    }
}
