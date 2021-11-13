package leetcode.leetcode11;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Leetcode1014 {

    public int maxScoreSightseeingPair(int[] values) {
        Deque<int[]> s=new ArrayDeque<>();
        for(int i=0;i<values.length;i++){
            int val=values[i]-i;
            while(!s.isEmpty()&&s.peekLast()[0]<=val){
                s.pollLast();
            }
            s.add(new int[]{val,i});
        }

        int result=Integer.MIN_VALUE;
        int base=0;
        for(int i=0;i<values.length-1;i++){
            if(i==s.peekFirst()[1])
                s.pollFirst();
            result=Math.max(result,values[i]+s.peekFirst()[0]+base);
            base++;
        }
        return result;
    }

}
