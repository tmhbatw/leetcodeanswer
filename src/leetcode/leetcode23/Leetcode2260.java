package leetcode.leetcode23;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2260 {

    public int minimumCardPickup(int[] cards) {
        int result =Integer.MAX_VALUE;
        int start = 0;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<cards.length;i++){
            if(set.contains(cards[i])){
                while(cards[start]!=cards[i]){
                    set.remove(cards[start++]);
                }
                start++;
                result=Math.min(result,set.size()+1);
            }else
                set.add(cards[i]);
        }

        return result==Integer.MAX_VALUE?-1:result;
    }
}
