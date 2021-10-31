package leetcode.leetcode10;

import java.util.*;

public class Leetcode950 {

    public int[] deckRevealedIncreasing(int[] deck) {
        int[] res=new int[deck.length];
        Queue<Integer> s=new LinkedList<>();
        for(int i=0;i<deck.length;i++) {
            s.add(i);
        }

        Arrays.sort(deck);
        for(int i=0;i<deck.length;i++){
            int index=s.poll();
            if(!s.isEmpty())
                s.add(s.poll());
            res[index]=deck[i];
        }
        return res;
    }
}
