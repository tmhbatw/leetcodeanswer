package leetcode.leetcode18;

import java.util.*;

public class Leetcode1772 {

    class Node{
        String s;
        int val;
        public Node(String s){
            this.s=s;
        }
    }
    public String[] sortFeatures(String[] features, String[] responses) {
        Node[] appearance=new Node[features.length];
        Map<String,Integer> map=new HashMap<>();

        for(int i=0;i<features.length;i++){
            appearance[i]=new Node(features[i]);
            map.put(features[i],i);
        }

        for(String re:responses){
            Set<Integer> set=new HashSet<>();
            for(String word:re.split(" ")){
                if(map.containsKey(word))
                    set.add(map.get(word));
            }
            for(int index:set)
                appearance[index].val++;
        }

        Arrays.sort(appearance,(o1,o2)->{
            return o2.val-o1.val;
        });
        for(int i=0;i<features.length;i++)
            features[i]=appearance[i].s;
        return features;
    }
}
