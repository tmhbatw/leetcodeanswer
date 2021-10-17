package forOffer2;

import java.util.HashMap;
import java.util.Map;

public class ForOffer34 {

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<order.length();i++)
            map.put(order.charAt(i),i);
        for(int i=1;i<words.length;i++){
            if(big(words[i-1],words[i],map))
                return false;
        }
        return true;
    }

    private boolean big(String a,String b,Map<Character,Integer> map){
        for(int i=0;i<Math.min(a.length(),b.length());i++){
            if(a.charAt(i)==b.charAt(i))
                continue;
            return map.get(a.charAt(i))<map.get(b.charAt(i));
        }
        return a.length()<=b.length();
    }
}
