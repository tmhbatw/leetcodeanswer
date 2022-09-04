package leetcode.leetcode15;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1487 {

    public String[] getFolderNames(String[] names) {
        Map<String,Integer> map=new HashMap<>();
        String[] result=new String[names.length];
        for(int i=0;i<names.length;i++){
            int num=getNumber(names[i]);
            if(num<=0){
                if(!map.containsKey(names[i])){
                    map.put(names[i],1);
                    result[i]=names[i];
                }else{
                    int cur = map.get(names[i]);
                    while(map.containsKey(names[i]+"("+cur+")")){
                        cur++;
                    }
                    map.put(names[i],cur+1);
                    result[i]=names[i]+"("+cur+")";
                }
            }else{
                int lastIndex=getLastIndex(names[i]);
                String same = names[i].substring(0,lastIndex);
                if(map.containsKey(names[i])||map.getOrDefault(same,0)>num){
                    int cur = map.getOrDefault(names[i],1);
                    while(map.containsKey(names[i]+"("+cur+")")){
                        cur++;
                    }
                    map.put(names[i],cur+1);
                    result[i]=names[i]+"("+cur+")";
                }else{
                    map.put(names[i],1);
                    result[i]=names[i];
                }
            }
        }

        return result;
    }

    private int getLastIndex(String cur){
        for(int j=cur.length()-1;j>=0;j--){
            if(cur.charAt(j)=='(')
                return j;
        }
        return -1;
    }

    private int getNumber(String cur){
        if(cur.charAt(cur.length()-1)!=')'){
            return -1;
        }
        int time = 0;
        int base = 1;
        for(int j=cur.length()-2;j>=0;j--){
            if(cur.charAt(j)=='('){
                if(j<cur.length()-2)
                    return time;
                break;
            }
            if(cur.charAt(j)<='z'&&cur.charAt(j)>='a')
                break;
            time +=base*(cur.charAt(j)-'0');
        }
        return -1;
    }




}
