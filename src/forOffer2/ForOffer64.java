package forOffer2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForOffer64 {

    class MagicDictionary {

        Map<Integer, List<String>> map;
        /** Initialize your data structure here. */
        public MagicDictionary() {
            this.map=new HashMap<>();
        }

        public void buildDict(String[] dictionary) {
            for(String cur:dictionary){
                map.putIfAbsent(cur.length(),new ArrayList<>());
                this.map.get(cur.length()).add(cur);
            }
        }

        public boolean search(String searchWord) {
            if(!map.containsKey(searchWord.length()))
                return false;
            List<String> list=map.get(searchWord.length());
            for(String curr:list){
                int diff=0;
                for(int i=0;i<curr.length();i++){
                    if(searchWord.charAt(i)!=curr.charAt(i))
                        diff++;
                }
                if(diff==1)
                    return true;
            }
            return false;
        }
    }
}
