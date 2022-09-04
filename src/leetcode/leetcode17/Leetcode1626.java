package leetcode.leetcode17;

import javax.print.attribute.HashAttributeSet;
import java.util.*;

public class Leetcode1626 {

    public int bestTeamScore(int[] scores, int[] ages) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<=1000;i++)
            list.add(new ArrayList<>());

        for(int i=0;i<ages.length;i++){
            list.get(ages[i]).add(scores[i]);
        }

        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(0,0);

        for(List<Integer> l:list){
            if(l.size()==0)
                continue;
            Collections.sort(l);

            for(int i=0;i<l.size();i++){
                int score = l.get(i);
                int sum = score;
                while(i<l.size()-1&& Objects.equals(l.get(i + 1), l.get(i))){
                    sum+=score;
                    i++;
                }

                sum += map.get(map.floorKey(score));
                map.put(score,sum);

                while(map.higherKey(score)!=null&&map.get(map.higherKey(score))<=sum){
                    score=map.higherKey(score);
                    map.remove(score);
                }
            }
        }

        return map.get(map.lastKey());
    }



}
