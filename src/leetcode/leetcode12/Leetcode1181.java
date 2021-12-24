package leetcode.leetcode12;

import java.util.*;

public class Leetcode1181 {

    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<phrases.length;i++){
            for(int j=0;j<phrases.length;j++){
                if(i==j)
                    continue;
                String[] start=phrases[i].split(" ");
                String[] end=phrases[j].split(" ");
                if(start[start.length-1].equals(end[0])){
                    set.add(phrases[i]+phrases[j].substring(end[0].length()));
                }
            }
        }

        List<String> res=new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }
}
