package leetcode.leetcode18;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode1797 {

    class AuthenticationManager {

        int timeToLive;
        Map<String,Integer> map=new HashMap<>();
        public AuthenticationManager(int timeToLive) {
            this.timeToLive=timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            map.put(tokenId,currentTime);
        }

        public void renew(String tokenId, int currentTime) {
            if(!map.containsKey(tokenId)||map.get(tokenId)<=currentTime-timeToLive)
                return;
            map.put(tokenId,currentTime);
        }

        public int countUnexpiredTokens(int currentTime) {
            int result=0;
            for(String key:map.keySet()){
                if(map.get(key)>currentTime-timeToLive)
                    result++;
            }
            return result;
        }
    }
}
