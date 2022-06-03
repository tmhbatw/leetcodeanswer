package leetcode.leetcode23;

import java.util.HashMap;
import java.util.Map;

public class Leetcode2284 {

    public String largestWordCount(String[] messages, String[] senders) {
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<messages.length;i++){
            int count = messages[i].split(" ").length;
            map.put(senders[i],map.getOrDefault(senders[i],0)+count);
        }

        String result = "";
        int count = 0;

        for(String key:map.keySet()){
            if(map.get(key)>count||map.get(key)==count&&result.compareTo(key)<0){
                count = map.get(key);
                result =key;
            }
        }

        return result;
    }
}
