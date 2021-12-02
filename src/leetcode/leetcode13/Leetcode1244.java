package leetcode.leetcode13;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode1244 {

    class Leaderboard {

        TreeMap<Integer,Integer> m1;
        Map<Integer,Integer> m2;
        public Leaderboard() {
            m1=new TreeMap<>((o1,o2)->{
                return o2-o1;
            });
            m2=new HashMap<>();
        }
        public void addScore(int playerId, int score) {
            if(m2.containsKey(playerId)){
                int pre=m2.get(playerId);
                if(m1.get(pre)==1)
                    m1.remove(pre);
                else
                    m1.put(pre,m1.get(pre)-1);

                pre+=score;
                m1.put(pre,m1.getOrDefault(pre,0)+1);

                m2.put(playerId,pre);
            }else{
                m2.put(playerId,score);
                m1.put(score,m1.getOrDefault(score,0)+1);
            }
        }

        public int top(int K) {
            int result=0;
            for(int key: m1.keySet()){
                int time=Math.min(m1.get(key),K);
                result+=time*key;
                K-=time;
                if(K==0)
                    break;
            }
            return result;
        }

        public void reset(int playerId) {
            if(m2.containsKey(playerId)){
                int score=m2.remove(playerId);
                if(m1.get(score)==1)
                    m1.remove(score);
                else
                    m1.put(score,m1.get(score)-1);
            }
        }
    }
}
